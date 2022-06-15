package ru.cb.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import ru.cb.demo.interfaces.grud.RepositoryClients;
import ru.cb.demo.interfaces.grud.RepositoryED243;
import ru.cb.demo.interfaces.grud.RepositoryED244;
import ru.cb.demo.models.abstrforms.ED1XX;
import ru.cb.demo.models.bankaccount.CheckingAccount;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.*;
import ru.cb.demo.services.сomputCenterServices.CheckED108;
import ru.cb.demo.services.сomputCenterServices.CheckED244;
import ru.cb.demo.services.сomputCenterServices.ComputingCenter;
import ru.cb.demo.utils.CurentTime;


import java.util.List;

/*
 * Тест для создания о отправки в ВЦ ED244
 * После получения по результаатм обработки ED201 или ED208
 * выводиться соответсвующее сообщенеи
 * Должен выполняться после добавления клиентов и создания ED243
 * @author radik
 * @version 1.0
 */
@SpringBootTest
public class ED244Test {

    //Наименование 1 компании
    String name1 = "Нефтяная компания";

    //Наименование 2 компании
    String name2 = "Нефтеперерабатывающая компания";

    //Номер 1 го ED244
    String ED244No = "НЕ25783";

    //Номер 2 го ED244
    String ED244No2 = "НЕ25784";

    //ED1XX
    ED1XX ed1XX;

    //ED244
    ED244 ed244;

    //ED108
    ED108 ed108;

    //Клиент отправитель
    Client clientAuthor;

    //Клиент получатель
    Client clientRecipient;

    //Список клиентов
    List<Client> clients;

    //Список ED243
    List<ED243> ed243s;

    //Список ED244
    List<ED244> ed244s;

    //Расчетный счет
    CheckingAccount checkingAccount;

    @Autowired
    RepositoryED244 repositoryED244;

    @Autowired
    RepositoryED243 repositoryED243;

    @Autowired
    RepositoryClients repositoryClients;

    @Autowired
    ComputingCenter computingCenter;

    @Autowired
    CheckED244 checkED244;

    @Autowired
    CheckED108 checkED108;

    /*
     * Тест для создания ED244 без ED243 и отправки в ВЦ
     * Если ED244 c указаным номером не существует в БД
     * создается новый
     * @author radik
     * @version 1.0
     */
    @Test
    void createED244WithoutED243()
    {
        clientInitialization();
        ed244s = repositoryED244.findED244sByEcno(ED244No2);
        if(ed244s.size()==0) {
            ed244 = grateNewED244();
            checkED108.grateED108(checkingAccount.getRS(),
                    checkingAccount.getBIK(),
                    checkingAccount.getINN(),
                    checkingAccount.getCorrespondentAccount(),
                    checkingAccount.getBankOfRecipient(),
                    1000, clientRecipient, ed244);
            checkED108.grateED108(checkingAccount.getRS(),
                    checkingAccount.getBIK(),
                    checkingAccount.getINN(),
                    checkingAccount.getCorrespondentAccount(),
                    checkingAccount.getBankOfRecipient(),
                    2000, clientRecipient, ed244);
        }
        else {
            ed244 = ed244s.get(0);
            ed244 = updateRequisites1(ed244);
        }

        outCtrlCode();
    }

    /*
     * Метод для создания нового ED244
     * @return ED244
     * @author radik
     * @version 1.0
     */
    private ED244 grateNewED244() {

        ED244 ed244 = new ED244();

        ed244.setEdDefineRequestCode(9);

        ed244.setEdReceiver(clientRecipient.getUniqueIdentifier());

        ed244.setEdСompiler(clientAuthor.getUniqueIdentifier());

        ed244.setEdDate(CurentTime.getCurentTime());

        ed244.setEcno(ED244No2);

        repositoryED244.save(ed244);

        return ed244;
    }

    /*
     * Тест для создания ED244 на основании ED243 и отправки в ВЦ
     * Если ED244 c указаным номером не существует в БД
     * создается новый
     * @author radik
     * @version 1.0
     */
    @Test
    void createBasedOnED243()
    {
        clientInitialization();

            ed244s = repositoryED244.findED244sByEcno(ED244No);
            if(ed244s.size()==0) {
                if (ed243s.size() > 0) {
                    ed244 = checkED244
                            .grateED244FromED243(ed243s.get(0), ED244No);
                    ed108 = checkED108.grateED108(checkingAccount.getRS(),
                            checkingAccount.getBIK(),
                            checkingAccount.getINN(),
                            checkingAccount.getCorrespondentAccount(),
                            checkingAccount.getBankOfRecipient(),
                            1000, clientRecipient, ed244);

                }
            }
            else {
                ed244 = ed244s.get(0);
                ed244=updateRequisites(ed244);
                repositoryED244.save(ed244);

            }
            outCtrlCode();
     }

    /*
     * Метод для вывода результат тестирования
     * @author radik
     * @version 1.0
     */
    private void outCtrlCode()
    {
        ed1XX = computingCenter
                .primaryProcessing(ed244,clientAuthor,clientRecipient);
        if(ed1XX instanceof ED201)
        {
            ED201 ed201 = (ED201) ed1XX;

            System
                    .out
                    .println("Возвращена ЭС ED201 c кодом ошибки :" + ed201.getCtrlCode());
        }
        else if(ed1XX instanceof ED208)
        {
            checkED108.setTransactionID(ed244);
            ED208 ed208 = (ED208) ed1XX;
            System
                    .out
                    .println("Возвращена ЭС ED208 c кодом обрабоки :"
                            + ed208.getCtrlCode()+
                            " и Текст пояснения :"+ed208.getAnnotation());
            ed208 = computingCenter.stateDelivery(ed244,clientAuthor);
            System
                    .out
                    .println("Возвращена ЭС ED208 c кодом обрабоки :"
                            + ed208.getCtrlCode()+
                            " и Текст пояснения :"+ed208.getAnnotation());
        }
    }

    /*
     * Метод для изменеия реквизитов ED244
     * Используется для создания или исправления ошибок
     * чтобы получить ED201 или ED208
     * @author radik
     * @version 1.0
     */
    private ED244 updateRequisites(ED244 ed244) {
        ed244.setEdAnswerRequestCode(5);

        return ed244;
    }

    /*
     * Метод для изменеия реквизитов ED244
     * Используется для создания или исправления ошибок
     * чтобы получить ED201 или ED208
     * @author radik
     * @version 1.0
     */
    private ED244 updateRequisites1(ED244 ed244) {
        ed244.setEdAnswerRequestCode(9);
        return ed244;
    }

    /*
     * Метод для инициализации клиентов банка
     * @author radik
     * @version 1.0
     */
    private void clientInitialization() {
        clients = repositoryClients.findClientsByName(name1);
        if(clients.size()>0) {
            clientAuthor = clients.get(0);
            checkingAccount=clientAuthor.getCheckingAccounts().get(0);
        }

        clients = repositoryClients.findClientsByName(name2);

        if(clients.size()>0) {
            clientRecipient = clients.get(0);
        }
    }
}
