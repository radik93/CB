package ru.cb.demo.services.clientServices;

import ru.cb.demo.models.bankaccount.CheckingAccount;
import ru.cb.demo.models.clients.Client;

import java.util.List;

/*
 * Интерфейс для реализации методов работы с клиентами с банкам
 * @author radik
 * @version 1.0
 */
public interface CustomerRegistration {
    /*
     * Метод для добавления нового клиента
     * Принимает в качетсве параметра объект класса Client
     * @return Возвращает false при наличии ошибок в заполнениии реквизитов
     * true если ошибок в заполнении нет
     * @author radik
     * @version 1.0
     */
    boolean addNewClient(Client client);


    /*
     * Метод для добавления нового расчетного счета
     * Принимает в качетсве параметра объект класса CheckingAccount и Client
     * к которму создается расчетный счет
     * @return Возвращает false при наличии ошибок в заполнениии реквизитов
     * расчетного счета true если ошибок в заполнении нет
     * @author radik
     * @version 1.0
     */
    boolean addCheckingAccount(CheckingAccount checkingAccount, Client client);

    /*
     * Метод для дполучения списка клиентов по имени
     * @return Везвращает списко клиентов банка удовлетворяющих условию запроса
     * @author radik
     * @version 1.0
     */
    List<Client> getClientByName(String name);
}
