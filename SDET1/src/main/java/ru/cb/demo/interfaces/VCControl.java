package ru.cb.demo.interfaces;

import ru.cb.demo.models.ED201;
import ru.cb.demo.models.ED208;
import ru.cb.demo.models.ED243;

public interface VCControl {
    ED201 performСontrol(ED243 ed243);
    ED208 successСontrol(ED243 ed243);
}
