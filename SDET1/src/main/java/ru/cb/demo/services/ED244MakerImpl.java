package ru.cb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.ED244Maker;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.interfaces.grud.ED108ModelRepositoris;
import ru.cb.demo.interfaces.grud.ED208ModelRepositoris;
import ru.cb.demo.interfaces.grud.ED243ModelRepositoris;
import ru.cb.demo.interfaces.grud.ED244ModelRepositoris;
import ru.cb.demo.models.*;


import java.util.ArrayList;
import java.util.List;

@Service
public class ED244MakerImpl implements ED244Maker {
    ED243 ed243;

    ED244 ed244;

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

    @Override
    public ED208 sendED244(int EDDefineRequestCode, int edReceiver, int edAuthor, boolean delivered, Client client) {

        ED208 ed208 = null;
        if(EDDefineRequestCode==9||EDDefineRequestCode==13){
            ed244=new ED244(31052022, EDDefineRequestCode, edReceiver, edAuthor);
            ed244ModelRepositoris.save(ed244);

            ed244.setED108s(grateED108(ed244,1000,client.getBIK(),client.getINN(),client.getPS()));
            ed244.setED108s(grateED108(ed244,2000,client.getBIK(),client.getINN(),client.getPS()));
            return saveAndContrED244(ed244,delivered);
        }
        else{
            ed243 = getED234(edReceiver);
            if(ed243!=null)
            {
                ed244=new ED244(31052022, EDDefineRequestCode,  ed243);
                ed244ModelRepositoris.save(ed244);
                ed244.setED108s(grateED108(ed244,3000,client.getBIK(),client.getINN(),client.getPS()));
                ed244.setED108s(grateED108(ed244,5000,client.getBIK(),client.getINN(),client.getPS()));
                ed208 = saveAndContrED244(ed244,delivered);

                //если ED244 доставлен отправителю то помечаем запрос ED243 отвеченным
                if(ed208.getCtrlCode()==2){
                    ed243.setAnAnswer(true);
                    ed243ModelRepositoris.save(ed243);
                }

            }
        }
        return ed208;
    }

    private ED243 getED234(int edReceiver){

        List<ED243> ed243List = ed243ModelRepositoris.findED243sByEdReceiverAndAnAnswer(edReceiver, false);
        if(ed243List.size()==0)
            return null;
        else
            return ed243List.get(0);
    }

    private List<ED108> grateED108(ED244 ed244, int SUM, int BIK, int INN, int PS) {
        List<ED108> ed108List;
        int ecno;

        ED108 ed108;
        ed108List = ed244.getED108s();
        if(ed108List==null) {
            ecno = 1;
            ed108List=new ArrayList<>();
        }
        else
            ecno = ed108List.size()+1;

        ed108 = new ED108(ecno,BIK, INN, PS, SUM);

        ed108.setEd244(ed244);

        ed108List.add(ed108);

        return ed108List;
    }

    public void saveED244(ED244 ed244)
    {
        for (ED108 ed108:ed244.getED108s())
        {
            ed108ModelRepositoris.save(ed108);
        }
    }

    private ED208 saveAndContrED244(ED244 ed244, boolean delivered) {

        saveED244(ed244);
        ED208 ed208;
        ed208 = vcControl.performСontrol244(ed244);

        if (ed208 == null)
            ed208 = vcControl.successСontrol244(ed244, delivered);
        return ed208;
    }

}
