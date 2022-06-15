package ru.cb.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cb.demo.models.bankaccount.CheckingAccount;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.services.clientServices.CustomerRegistration;

import java.util.List;

/*
 * Тест для добавления клиентов банка
 * Для последующих тестов обязательно необходимо добавить 2 клиентов
 * для имтиации их взаимодейсвия
 * @author radik
 * @version 1.0
 */
@SpringBootTest
public class AddClientTest {

    //Клиент 1
    Client client1;

    //Расчетный счет 1 го клиента
    CheckingAccount checkingAccount1;

    //Наименование 1 компании
    String name1 = "Нефтяная компания";

    //Расчетный счет
    private int RS1 = 128834759;

    //БИК
    private int BIK1 = 86395072;

    //ИНН
    private int INN1 = 1601235708;

    //Корреспондентский счет
    private int correspondentAccount1 = 701856693;

    //Банк получатель
    private String BankOfRecipient1 = "АО Сбербанк";


    //Клиент 2
    Client client2;

    //Расчетный счет 2 го клиента
    CheckingAccount checkingAccount2;

    //Наименование 2 компании
    String name2 = "Нефтеперерабатывающая компания";

    //Расчетный счет
    private int RS2 = 228834759;

    //БИК
    private int BIK2 = 86495072;

    //ИНН
    private int INN2 = 1501235708;

    //Корреспондентский счет
    private int correspondentAccount2 = 741856693;

    //Банк получатель
    private String BankOfRecipient2 = "АО ВТБ";

    @Autowired
    CustomerRegistration customerRegistration;

    /*
     * Тест для добавления 1 го клиента
     * @author radik
     * @version 1.0
     */
    @Test
    public void addClient1() {

        client1 = new Client();

        client1.setName(name1);

        if(customerRegistration.addNewClient(client1))
        {
            System.out.println("Клиент добавлен");
        }
        else
        {
            System.out.println("Ошибка при добавлении клиента добавлен");
        }

    }

    /*
     * Тест для добавления расчетного счета 1 го клиента
     * запускается только после успешного добавления 1 клиента
     * @author radik
     * @version 1.0
     */
    @Test
    public void addCheckingAccount1() {
       List<Client> clients = customerRegistration.getClientByName(name1);

       if(clients.size()>0)
       {
           checkingAccount1 = grateCheckingAccount(BankOfRecipient1, BIK1, INN1, RS1, correspondentAccount1);
           checkingAccount1.setClient(clients.get(0));

           if(customerRegistration.addCheckingAccount(checkingAccount1,clients.get(0)))
           {
               System.out.println("Расчетный счет добавлен");
           }
           else
           {
               System.out.println("Ошибка при добавлении расчетного счета добавлен");
           }
       }

    }

    /*
     * Тест для добавления 2 го клиента
     * @author radik
     * @version 1.0
     */
    @Test
    public void addClient2() {

        client2 = new Client();

        client2.setName(name2);

        if(customerRegistration.addNewClient(client2))
        {
            System.out.println("Клиент добавлен");
        }
        else
        {
            System.out.println("Ошибка при добавлении клиента добавлен");
        }

    }

    /*
     * Тест для добавления расчетного счета 2 го клиента
     * запускается только после успешного добавления 2 клиента
     * @author radik
     * @version 1.0
     */
    @Test
    public void addCheckingAccount2() {
        List<Client> clients = customerRegistration.getClientByName(name2);

        if(clients.size()>0)
        {
            checkingAccount2 = grateCheckingAccount(BankOfRecipient2, BIK2, INN2, RS2, correspondentAccount2);
            checkingAccount2.setClient(clients.get(0));

            if(customerRegistration.addCheckingAccount(checkingAccount2,clients.get(0)))
            {
                System.out.println("Расчетный счет добавлен");
            }
            else
            {
                System.out.println("Ошибка при добавлении расчетного счета добавлен");
            }
        }

    }
    /*
     * Метод для создания объекта класа расчетный счет
     * @author radik
     * @version 1.0
     */
    private CheckingAccount grateCheckingAccount(String BankOfRecipient, int BIK, int INN, int RS, int correspondentAccount) {
        CheckingAccount checkingAccount = new CheckingAccount();

        checkingAccount.setBankOfRecipient(BankOfRecipient);

        checkingAccount.setBIK(BIK);

        checkingAccount.setINN(INN);

        checkingAccount.setRS(RS);

        checkingAccount.setCorrespondentAccount(correspondentAccount);

        return checkingAccount;
    }
}
