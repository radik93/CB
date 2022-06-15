package ru.cb.demo.services.сomputCenterServices;

import ru.cb.demo.models.abstrforms.ED1XX;
import ru.cb.demo.models.abstrforms.ED2XX;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.ED208;

/*
 * Интерфейс для реализации методов работы вычислительного центра
 * @author radik
 * @version 1.0
 */
public interface ComputingCenter {

    /*
     * Метод для проверки ЭС ED243 ED244
     * @return Возвращает ED201 если есть ошибки, ED208 если нет ошибок  с результатом обработки 1
     * @author radik
     * @version 1.0
     */
    ED1XX primaryProcessing(ED2XX ed2XX , Client clientAuthor, Client clientRecipient);

    /*
     * Метод для проверки доставки ЭС ED243 ED244
     * @return ED208 с результатом обработки 2 если ЭС доставлено,
     * ED208 с результатом обработки 3 если ЭС не доставлено
     * @author radik
     * @version 1.0
     */
    ED208 stateDelivery(ED2XX ed2XX, Client clientAuthor);

}
