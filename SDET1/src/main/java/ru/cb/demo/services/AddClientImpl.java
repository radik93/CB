package ru.cb.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.AddClient;
import ru.cb.demo.interfaces.grud.ClientModelsRepositoris;
import ru.cb.demo.models.Client;

@Service
public class AddClientImpl implements AddClient {

    @Autowired
    ClientModelsRepositoris clientModelsRepositoris;

    @Override
    public void addNewClient(Client client) {
       clientModelsRepositoris.save(client);
    }

}
