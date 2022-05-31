package ru.cb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.interfaces.grud.*;
import ru.cb.demo.models.*;


import java.util.List;

@Service
public class VCControlImpl implements VCControl {

    @Autowired
    ClientModelsRepositoris clientModelsRepositoris;

    @Autowired
    ED201ModelRepositoris ed201ModelRepositoris;

    @Autowired
    ED208ModelRepositoris ed208ModelRepositoris;

    @Autowired
    ED243ModelRepositoris ed243ModelRepositoris;

    @Override
    public ED201 performСontrol(ED243 ed243) {
        List<Client> clientList=clientModelsRepositoris.findClientsByEdReceiver(ed243.getEdReceiver());

        //если не найден клиент с УИП то ошибка
        if (clientList.size()==0)
        {
            ED201 ed201 = new ED201(30052022,1,ed243);
            ed201ModelRepositoris.save(ed201);
            return ed201;
        }

        return null;
    }

    @Override
    public ED208 successСontrol(ED243 ed243, boolean delivered) {
        int ctrlCode;
        if(delivered)
            ctrlCode=2;
        else
            ctrlCode=3;
        ED208 ed208 = new ED208(31052022,ctrlCode,ed243);

        ed208ModelRepositoris.save(ed208);
        return ed208;
    }

    @Override
    public ED208 performСontrol244(ED244 ed244) {
        List<Client> clientList=clientModelsRepositoris.findClientsByEdReceiver(ed244.getEdAuthor());
        if (clientList.size()==0)
        {
            ED208 ed208 = new ED208(31052022,1,ed244);
            ed208ModelRepositoris.save(ed208);
            return ed208;
        }
        return null;
    }

    @Override
    public ED208 successСontrol244(ED244 ed244, boolean delivered) {
        int ctrlCode;
        if(delivered)
            ctrlCode= 2;
        else
            ctrlCode= 3;
        ED208 ed208 = new ED208(31052022,ctrlCode,ed244);

        ed208ModelRepositoris.save(ed208);
        return ed208;
    }


}
