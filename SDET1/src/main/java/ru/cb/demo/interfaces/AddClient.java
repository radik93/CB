package ru.cb.demo.interfaces;

import ru.cb.demo.models.Client;
/*
 * Интерфейс для работы с клиентам банка
 * @author radik
 * @version 1.0
 */
public interface AddClient {
    /*
     * Метод для добавления новго клиента банка
     * @author radik
     * @version 1.0
     */
    void addNewClient(Client cLient);
}
