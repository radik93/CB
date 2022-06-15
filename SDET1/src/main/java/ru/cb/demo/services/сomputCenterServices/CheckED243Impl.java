package ru.cb.demo.services.сomputCenterServices;

import org.springframework.stereotype.Service;
import ru.cb.demo.models.emforms.ED243;


@Service
public class CheckED243Impl implements CheckED243{


    @Override
    public int checDetailsED243(ED243 ed243) {
        if(ed243.getEdDefineRequestCode()==0)
            return 6;

        return 0;
    }

}
