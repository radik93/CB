package ru.cb.demo.services.сomputCenterServices;

import ru.cb.demo.models.emforms.ED243;
import ru.cb.demo.models.emforms.ED244;

/*
 * Интерфейс для проверки реквизитов характерных только ЭС ED244
 * @author radik
 * @version 1.0
 */
public interface CheckED244 {
    /*
     * Метод для проверки заполнеия реквизитов, свойственных только для  ЭС ED244
     * если EDDefineRequestCode 9 или 13 то реквизиты
     * InitialED на заполнение не проверяется
     * @return Возвращает код ошибки, 0 если нет ошибок
     * @author radik
     * @version 1.0
     */
    int checDetailsED244(ED244 ed244);

    /*
     * Метод для создания ED244 на основании ED243
     * @return Возвращает объек класа ed243
     * @author radik
     * @version 1.0
     */
    ED244 grateED244FromED243(ED243 ed243, String ecno);
}
