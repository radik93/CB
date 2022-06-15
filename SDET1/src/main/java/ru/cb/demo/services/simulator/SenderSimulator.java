package ru.cb.demo.services.simulator;

/*
 * Интерфейс для реализации эмулятора системы отправки ЭС
 * @author radik
 * @version 1.0
 */
public interface SenderSimulator {

    /*
     * Метод для реализации эмулятора системы отправки ЭС
     * случайно генерирует true и false
     * @return Возвращает false при ошибке доставик true при доставке получаетлю
     * @author radik
     * @version 1.0
     */
    boolean departure();
}
