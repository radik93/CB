package ru.cb.demo.services.сomputCenterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.grud.RepositoryED201;
import ru.cb.demo.interfaces.grud.RepositoryED208;
import ru.cb.demo.models.abstrforms.ED2XX;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.ED201;
import ru.cb.demo.models.emforms.ED208;
import ru.cb.demo.utils.CurentTime;
import ru.cb.demo.utils.DescErr208;

@Service
public class CheckED2XXImpl implements CheckED2XX{

    @Autowired
    RepositoryED201 repositoryED201;

    @Autowired
    RepositoryED208 repositoryED208;

    @Override
    public int checDetailsED2XX(ED2XX ed2XX) {
        if(ed2XX.getEdDate()==0)
            return 1;
        if(ed2XX.getEdСompiler()==null)
            return 2;
        if(ed2XX.getEdReceiver()==null)
            return 3;

        return 0;
    }

    @Override
    public int checUniqueIdentifiers(ED2XX ed2XX, Client clientAuthor, Client clientRecipient) {

        if (!ed2XX.getEdСompiler().equals(clientAuthor.getUniqueIdentifier())) {
            return 4;
        }
        if (!ed2XX.getEdReceiver().equals(clientRecipient.getUniqueIdentifier())) {
            return 5;
        }

        return 0;
    }

    @Override
    public ED201 grateED201(ED2XX ed2xx, Client clientAuthor, int errCode) {

        ED201 ed201 = new ED201();

        ed201.setEdDate(CurentTime.getCurentTime());

        ed201.setEd2XX(ed2xx);

        ed201.setCtrlCode(errCode);

        repositoryED201.save(ed201);

        ed201.setEcno(clientAuthor.getPrefix()+ed201.getId());

        repositoryED201.save(ed201);

        return ed201;
    }

    @Override
    public ED208 grateED208(ED2XX ed2xx, Client clientAuthor, int ctrlCode) {

        ED208 ed208 = new ED208();

        ed208.setEdDate(CurentTime.getCurentTime());

        ed208.setEd2XX(ed2xx);

        ed208.setCtrlCode(ctrlCode);

        ed208.setAnnotation(DescErr208.getDescCtrlED208(ctrlCode));

        repositoryED208.save(ed208);

        ed208.setEcno(clientAuthor.getPrefix()+ed208.getId());

        repositoryED208.save(ed208);

        return ed208;
    }
}
