package ru.cb.demo.services.сomputCenterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.models.abstrforms.ED1XX;
import ru.cb.demo.models.abstrforms.ED2XX;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.ED208;
import ru.cb.demo.models.emforms.ED243;
import ru.cb.demo.models.emforms.ED244;
import ru.cb.demo.services.simulator.SenderSimulator;

@Service
public class ComputingCenterImpl implements ComputingCenter{

    @Autowired
    CheckED243 checkED243;

    @Autowired
    CheckED244 checkED244;

    @Autowired
    CheckED2XX checkED2XX;

    @Autowired
    SenderSimulator senderSimulator;

    int errCode=0;

    @Override
    public ED1XX primaryProcessing(ED2XX ed2XX, Client clientAuthor, Client clientRecipient) {

        errCode = checkED2XX.checDetailsED2XX(ed2XX);
        if(errCode==0)
        errCode = checkED2XX.checUniqueIdentifiers(ed2XX, clientAuthor, clientRecipient);

        if(ed2XX instanceof ED243)
        {
            if(errCode==0)
            errCode = checkED243.checDetailsED243((ED243) ed2XX);
        }

        if(ed2XX instanceof ED244)
        {
            if(errCode==0)
                errCode = checkED244.checDetailsED244((ED244) ed2XX);
        }

        if(errCode!=0)
        return checkED2XX.grateED201(ed2XX, clientAuthor, errCode);
        else
        return checkED2XX.grateED208(ed2XX, clientAuthor, 1);
    }

    @Override
    public ED208 stateDelivery(ED2XX ed2XX, Client clientAuthor) {

        int ctrlCode=3;
        if(senderSimulator.departure())
            ctrlCode=2;

        return checkED2XX.grateED208(ed2XX, clientAuthor, ctrlCode);
    }

}
