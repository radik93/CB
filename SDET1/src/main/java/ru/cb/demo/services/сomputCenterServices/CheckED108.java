package ru.cb.demo.services.сomputCenterServices;

import ru.cb.demo.models.abstrforms.ED2XX;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.ED108;
import ru.cb.demo.models.emforms.ED244;

/*
 * Интерфейс для работы ЭС ED108
 * @author radik
 * @version 1.0
 */
public interface CheckED108 {

    /*
     * Метод для генерации ED108
     * В качестве параметров принимает банковские реквизиты
     * и родительский объект ED243 или ED244
     * @return Возвращает код ошибки, 0 если нет ошибок
     * @author radik
     * @version 1.0
     */
    ED108 grateED108(int RS, int BIK, int INN
            , int correspondentAccount, String BankOfRecipient
            , float SUM, Client clientAuthor,
                     ED2XX ed2XX);


    /*
     * Метод для генерации TransactionID ED108 уникального в рамках ED244
     * В качестве параметров принимает объект класса ED244
     * @author radik
     * @version 1.0
     */
    void setTransactionID(ED244 ed244);
}
