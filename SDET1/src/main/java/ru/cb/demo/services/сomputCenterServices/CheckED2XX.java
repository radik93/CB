package ru.cb.demo.services.сomputCenterServices;

import ru.cb.demo.models.abstrforms.ED2XX;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.ED201;
import ru.cb.demo.models.emforms.ED208;

/*
 * Интерфейс для проверки ЭС наследуемых от ED2XX
 * @author radik
 * @version 1.0
 */
public interface CheckED2XX {

    /*
     * Метод для проверки заполнения реквизитов ЭС наследуемых
     * от ED2XX. В качестве параметров принимает объект класса ED2XX
     * @return Возвращает код ошибки, 0 если нет ошибок
     * @author radik
     * @version 1.0
     */
    int checDetailsED2XX(ED2XX ed2XX);

    /*
     * Метод для проверки правильности УИО и УИП ЭС наследуемых
     * от ED2XX принимает в качестве параметров объект ЭС наследкуемой от формы ED2XX и клиента оправителя и получаетля
     * @return Возвращает код ошибки, 0 если нет ошибок
     * @author radik
     * @version 1.0
     */
    int checUniqueIdentifiers(ED2XX ed2XX, Client clientAuthor, Client clientRecipient);

    /*
     * Метод для генерации ED201
     * В качетве параметров принимает ЭС ED243 отправителя ЭС и код ошибки
     * @return Возвращает ЭС ED201
     * @author radik
     * @version 1.0
     */
    ED201 grateED201(ED2XX ed2XX, Client clientAuthor, int errCode);

    /*
     * Метод для генерации ED208
     * В качетве параметров принимает ЭС ED243 отправителя ЭС и код результата обработки
     * @return Возвращает ЭС ED208
     * @author radik
     * @version 1.0
     */
    ED208 grateED208(ED2XX ed2XX, Client clientAuthor, int ctrlCode);

}
