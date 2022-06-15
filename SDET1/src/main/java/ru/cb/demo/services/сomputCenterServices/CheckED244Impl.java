package ru.cb.demo.services.сomputCenterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.grud.RepositoryED244;
import ru.cb.demo.models.emforms.ED243;
import ru.cb.demo.models.emforms.ED244;
import ru.cb.demo.utils.CurentTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CheckED244Impl implements CheckED244{

    //EDDefineRequestCode при котором составляется ED244 без запроса ED243
    Integer[] codeWithoutRequest = new Integer[]{9, 13};

    List<Integer> codeWithoutRequestList = new ArrayList<>(Arrays.asList(codeWithoutRequest));

    @Autowired
    RepositoryED244 repositoryED244;

    @Override
    public int checDetailsED244(ED244 ed244) {

        if(ed244.getEdDefineRequestCode()==0)
            return 6;

        if(ed244.getEdAnswerRequestCode()==0)
            return 7;

        if(!codeWithoutRequestList.contains(ed244.getEdDefineRequestCode()))
        {
            if(ed244.getInitialEcno()==null)
                return 8;
            if (ed244.getInitialEdDate()==0)
                return 9;
        }
         return 0;
    }

    @Override
    public ED244 grateED244FromED243(ED243 ed243, String ecno) {
        ED244 ed244 = new ED244();

        ed244.setEdDefineRequestCode(ed243.getEdDefineRequestCode());

        ed244.setInitialEdDate(ed243.getEdDate());

        ed244.setInitialEcno(ed243.getEcno());

        ed244.setEdReceiver(ed243.getEdReceiver());

        ed244.setEdСompiler(ed243.getEdСompiler());

        ed244.setEd2XX(ed243);

        ed244.setEdDate(CurentTime.getCurentTime());

        ed244.setEcno(ecno);

        repositoryED244.save(ed244);

        return ed244;
    }
}
