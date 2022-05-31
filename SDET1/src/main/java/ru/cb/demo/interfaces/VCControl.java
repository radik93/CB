package ru.cb.demo.interfaces;

import ru.cb.demo.models.ED201;
import ru.cb.demo.models.ED208;
import ru.cb.demo.models.ED243;
import ru.cb.demo.models.ED244;

import java.util.List;

public interface VCControl {
    ED201 performСontrol(ED243 ed243);
    ED208 successСontrol(ED243 ed243, boolean delivered);

    ED208 performСontrol244(ED244 ed244);

    //List<ED243> getED243(int edReceiver);

    ED208 successСontrol244(ED244 ed244, boolean delivered);

  //  List<ED244> getED244(int edAuthor);
}
