package ru.cb.demo.services;

import org.springframework.stereotype.Service;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.models.ED201;
import ru.cb.demo.models.ED243;

@Service
public class VCControlImpl implements VCControl {
    @Override
    public ED201 performСontrol(ED243 ed243) {
        return null;
    }
}
