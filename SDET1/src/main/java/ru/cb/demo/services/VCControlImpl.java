package ru.cb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.interfaces.grud.ClientModelsRepositoris;
import ru.cb.demo.interfaces.grud.ED201ModelRepositoris;
import ru.cb.demo.interfaces.grud.ED208ModelRepositoris;
import ru.cb.demo.models.Client;
import ru.cb.demo.models.ED201;
import ru.cb.demo.models.ED208;
import ru.cb.demo.models.ED243;

import java.util.List;

@Service
public class VCControlImpl implements VCControl {

    @Autowired
    ClientModelsRepositoris clientModelsRepositoris;

    @Autowired
    ED201ModelRepositoris ed201ModelRepositoris;

    @Autowired
    ED208ModelRepositoris ed208ModelRepositoris;

    @Override
    public ED201 performСontrol(ED243 ed243) {
        List<Client> clientList=clientModelsRepositoris.findClientsByEdReceiver(ed243.getEdReceiver());

        System.out.println(clientList.size());
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
}
