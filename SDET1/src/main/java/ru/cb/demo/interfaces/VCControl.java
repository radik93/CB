package ru.cb.demo.interfaces;


import ru.cb.demo.models.*;

/*
 * Интерфейс для работы ВЦ
 * @author radik
 * @version 1.0
 */
public interface VCControl {
    /*
     * Метод проверят форму ED243 на корретность заполения реквезитов
     * @return Везвращает  Форму ED201 с кодом если есть ошибки null нет ошибок
     * @author radik
     * @version 1.0
     */
    ED201 performСontrol(ED243 ed243);
    /*
     * Метод проверят форму создает форму ED208 в зависимости от статуса доставки
     * @return Везвращает  Форму ED208
     * @author radik
     * @version 1.0
     */
    ED208 successСontrol(ED243 ed243, boolean delivered);

    /*
     * Метод проверят форму ED244 на корретность заполения реквезитов
     * @return Везвращает  Форму ED208 с кодом если есть ошибки null нет ошибок
     * @author radik
     * @version 1.0
     */
    ED208 performСontrol244(ED244 ed244);

    /*
     * Метод проверят форму создает форму ED208 в зависимости от статуса доставки
     * @return Везвращает  Форму ED208
     * @author radik
     * @version 1.0
     */
    ED208 successСontrol244(ED244 ed244, boolean delivered);

}
