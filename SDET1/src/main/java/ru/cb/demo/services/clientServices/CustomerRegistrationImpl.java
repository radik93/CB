package ru.cb.demo.services.clientServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.grud.RepositoryCheckingAccount;
import ru.cb.demo.interfaces.grud.RepositoryClients;
import ru.cb.demo.models.bankaccount.CheckingAccount;
import ru.cb.demo.models.clients.Client;

import java.util.List;

@Service
public class CustomerRegistrationImpl implements CustomerRegistration {

    @Autowired
    RepositoryClients repositoryClients;

    @Autowired
    RepositoryCheckingAccount repositoryCheckingAccount;

    @Override
    public boolean addNewClient(Client client) {

        String Prefix;

        if(client.getName()==null)
        return false;

        Prefix = grateUniqueIdentifier(client.getName());

        client.setPrefix(Prefix);

        repositoryClients.save(client);

        client.setUniqueIdentifier(Prefix+client.getId());

        repositoryClients.save(client);
        return true;
    }

    @Override
    public boolean addCheckingAccount(CheckingAccount checkingAccount, Client client) {
        if(checkingAccount.getBankOfRecipient()==null||
        checkingAccount.getBIK()==0||
        checkingAccount.getINN()==0||
        checkingAccount.getRS()==0||
        checkingAccount.getCorrespondentAccount()==0)
        return false;

        checkingAccount.setClient(client);

        repositoryCheckingAccount.save(checkingAccount);

        return true;
    }

    @Override
    public List<Client> getClientByName(String name) {
        return repositoryClients.findClientsByName(name);
    }

    private String grateUniqueIdentifier(String name) {

        if(name.length()>2)
            name=name.substring(0,2);

        name = name.toUpperCase();

        return name;
    }
}
