package ru.cb.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.interfaces.grud.ED108ModelRepositoris;
import ru.cb.demo.interfaces.grud.ED208ModelRepositoris;
import ru.cb.demo.interfaces.grud.ED243ModelRepositoris;
import ru.cb.demo.interfaces.grud.ED244ModelRepositoris;
import ru.cb.demo.models.ED108;
import ru.cb.demo.models.ED208;
import ru.cb.demo.models.ED243;
import ru.cb.demo.models.ED244;
import ru.cb.demo.utils.CodeAck;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SendED244 {

    int EDDefineRequestCode;

    @Autowired
    VCControl vcControl;

    @Autowired
    ED243ModelRepositoris ed243ModelRepositoris;

    @Autowired
    ED244ModelRepositoris ed244ModelRepositoris;

    @Autowired
    ED108ModelRepositoris ed108ModelRepositoris;

    @Autowired
    ED208ModelRepositoris ed208ModelRepositoris;

    ED243 ed243;

    ED244 ed244;


    int edReceiver  = 654;

    int edAuthor  = 659;

    boolean delivered=true;

    @Test
    public void sendED244() {
     EDDefineRequestCode= CodeAck.getCode("Без запроса 1");
    if(EDDefineRequestCode==9||EDDefineRequestCode==13){
         ed244=new ED244(31052022, EDDefineRequestCode, edReceiver, edAuthor);
         ed244.setED108s(grateED108(ed244,1000));
         ed244.setED108s(grateED108(ed244,2000));
         saveAndContrED244(ed244);

     }
     else{
         ed243 = getED234(edReceiver);
         if(ed243!=null)
         {
             ed244=new ED244(31052022, EDDefineRequestCode,  ed243);
             ed244.setED108s(grateED108(ed244,3000));
             ed244.setED108s(grateED108(ed244,5000));

             //если ED244 доставлен отправителю то помечаем запрос ED243 отвеченным
             if(saveAndContrED244(ed244)==2){
                 ed243.setAnAnswer(true);
                 ed243ModelRepositoris.save(ed243);
             }

         }
     }

    }

    private ED243 getED234(int edReceiver){

        List<ED243> ed243List = ed243ModelRepositoris.findED243sByEdReceiverAndAnAnswer(edReceiver, false);
        if(ed243List.size()==0)
        return null;
        else
        return ed243List.get(0);
    }

    private List<ED108> grateED108(ED244 ed244, int SUM) {
        List<ED108> ed108List;
        int id;

        ED108 ed108;
        ed108List = ed244.getED108s();
        if(ed108List==null) {
            id = 1;
            ed108List=new ArrayList<>();
        }
        else
          id = ed108List.size()+1;

        ed108 = new ED108((long) id,912345698, 1612345698, 12387654, SUM);

        ed108.setEd244(ed244);

        ed108List.add(ed108);

        return ed108List;
    }

    public void saveED244(ED244 ed244)
    {


        ed244ModelRepositoris.save(ed244);
        for (ED108 ed108:ed244.getED108s())
        {
           // System.out.println(ed108.getSUM());
            ed108ModelRepositoris.save(ed108);
        }
    }

    private int saveAndContrED244(ED244 ed244) {
        saveED244(ed244);
        ED208 ed208;

        int ctrlCode;
        ed208 = vcControl.performСontrol244(ed244);

        if (ed208 == null)
            ed208 = vcControl.successСontrol244(ed244, delivered);

        ctrlCode = ed208.getCtrlCode();
        System.out.println("CtrlCode: " + ed208.getCtrlCode());
        return ctrlCode;
    }
}
