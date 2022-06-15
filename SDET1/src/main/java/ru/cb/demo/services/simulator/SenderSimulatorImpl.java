package ru.cb.demo.services.simulator;

import org.springframework.stereotype.Service;
import ru.cb.demo.models.emforms.ED243;

import java.util.Random;

@Service
public class SenderSimulatorImpl implements SenderSimulator {
    @Override
    public boolean departure() {
        Random r = new Random();
        return r.nextBoolean();
    }
}
