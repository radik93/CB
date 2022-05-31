package ru.cb.demo.interfaces;

import ru.cb.demo.models.Client;
import ru.cb.demo.models.ED208;
/*
 * Интерфейс для работы с формой ED244
 * @author radik
 * @version 1.0
 */
public interface ED244Maker {
    /*
     * Метод для обработки и возвращения формы ED208 c соттветсвующим кодом
     * Может создать форму на основе форме ED243 и без него если EDDefineRequestCode=9 или 13
     * @return Везвращает  Форму ED208
     * @author radik
     * @version 1.0
     */
    ED208 sendED244(int EDDefineRequestCode, int edReceiver, int edAuthor, boolean delivered, Client client);
}
