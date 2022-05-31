package ru.cb.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.interfaces.grud.ED243ModelRepositoris;
import ru.cb.demo.models.ED201;
import ru.cb.demo.models.ED208;
import ru.cb.demo.models.ED243;


@SpringBootTest
class SendED243 {

    ED243 ed243;

    ED201 ed201;

    ED208 ed208;

    int edReceiver1  = 654;


    int edAuthor1  = 659;

    boolean delivered=false;

    @Autowired
    VCControl vcControl;

    @Autowired
    ED243ModelRepositoris ed243ModelRepositoris;

    @Test
    public void sendED243() {
        grateED243();
        ed201=vcControl.performСontrol(ed243);
        if(ed201!=null)
        {
            System.out.println("ctrlCode 201: " + ed201.getCtrlCode());
        }
        else {
            ed208 = vcControl.successСontrol(ed243,getStatusDelivered());
            System.out.println("ctrlCode 208: " + ed208.getCtrlCode());
        }
    }

    private void grateED243() {
        ed243=new ED243(31052022,edAuthor1,edReceiver1,5,delivered);
        ed243ModelRepositoris.save(ed243);
    }

    private boolean getStatusDelivered() {
        return true;
    }
}
