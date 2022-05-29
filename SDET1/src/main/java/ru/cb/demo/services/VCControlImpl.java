package ru.cb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.interfaces.grud.ClientModelsRepositoris;
import ru.cb.demo.models.Client;
import ru.cb.demo.models.ED201;
import ru.cb.demo.models.ED208;
import ru.cb.demo.models.ED243;

import java.util.List;

@Service
public class VCControlImpl implements VCControl {

    @Autowired
    ClientModelsRepositoris clientModelsRepositoris;

    @Override
    public ED201 performСontrol(ED243 ed243) {
        List<Client> clientList=clientModelsRepositoris.findClientsByEdReceiver(ed243.getEdReceiver());
        //если не найден клиент с УИП то ошибка
        if (clientList==null)
        {
            ED201 ed201 = new ED201(30052022,1);
            return ed201;

        }
        return null;
    }

    @Override
    public ED208 successСontrol(ED243 ed243) {
        return null;
    }
}
