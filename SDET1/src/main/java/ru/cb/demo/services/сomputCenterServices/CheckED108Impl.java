package ru.cb.demo.services.сomputCenterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.grud.RepositoryED108;
import ru.cb.demo.models.abstrforms.ED1XX;
import ru.cb.demo.models.abstrforms.ED2XX;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.ED108;
import ru.cb.demo.models.emforms.ED244;
import ru.cb.demo.utils.CurentTime;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckED108Impl implements CheckED108{

    private int maxTransactionID = 0;

    private List<ED108> ed108s;

    @Autowired
    RepositoryED108 repositoryED108;

    @Override
    public ED108 grateED108(int RS, int BIK,
                            int INN, int correspondentAccount,
                            String BankOfRecipient,
                            float SUM, Client clientAuthor,
                            ED2XX ed2XX) {


        ED108 ed108 = new ED108(RS, BIK,
         INN,  correspondentAccount,
         BankOfRecipient,  SUM);

        ed108.setEdDate(CurentTime.getCurentTime());

        ed108.setEd2XX(ed2XX);

        repositoryED108.save(ed108);

        ed108.setEcno(clientAuthor.getPrefix()+ed108.getId());

        repositoryED108.save(ed108);

        return ed108;

    }

    @Override
    public void setTransactionID(ED244 ed244) {
        ed108s = getDocED108(ed244);
        if(ed244.getEd2XX()!=null)
            ed108s.addAll(getDocED108(ed244.getEd2XX()));

        for (ED108 ed108 : ed108s)
        {
            if(ed108.getTransactionID()>maxTransactionID)
            {
                maxTransactionID=ed108.getTransactionID();
            }
        }

        for (ED108 ed108 : ed108s)
        {
            if(ed108.getTransactionID()==0)
            {
                ed108.setTransactionID(++maxTransactionID);

                repositoryED108.save(ed108);
            }
        }

    }

    //метод получает все объекты класса ED108 связанных с ED244 и ED243
    private List<ED108> getDocED108(ED2XX ed2xx)
    {
        List<ED1XX> ed1XXList;

        List<ED108> ed108List=new ArrayList<>();
        ed1XXList = ed2xx.getEd1XXES();
        for (ED1XX ed1XX : ed1XXList)
        {
            if(ed1XX instanceof ED108)
            {
                ed108List.add((ED108) ed1XX);
            }
        }
            return ed108List;
    }
}
