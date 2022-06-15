package ru.cb.demo.services.сomputCenterServices;

import ru.cb.demo.models.emforms.ED243;


/*
 * Интерфейс для проверки реквизитов характерных только ЭС ED243
 * @author radik
 * @version 1.0
 */
public interface CheckED243 {

    /*
     * Метод для проверки кода запроса ЭС ED243
     * @return Возвращает код ошибки, 0 если нет ошибок
     * @author radik
     * @version 1.0
     */
    int checDetailsED243(ED243 ed243);

}
