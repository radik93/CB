package ru.cb.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cb.demo.interfaces.grud.RepositoryClients;
import ru.cb.demo.interfaces.grud.RepositoryED243;
import ru.cb.demo.models.abstrforms.ED1XX;
import ru.cb.demo.models.clients.Client;
import ru.cb.demo.models.emforms.ED108;
import ru.cb.demo.models.emforms.ED201;
import ru.cb.demo.models.emforms.ED208;
import ru.cb.demo.models.emforms.ED243;
import ru.cb.demo.services.сomputCenterServices.ComputingCenter;
import ru.cb.demo.utils.CurentTime;

import java.util.List;

/*
 * Тест для создания о отправки в ВЦ ED243
 * После получения по результаатм обработки ED201 или ED208
 * выводиться соответсвующее сообщенеи
 * Должен выполняться после добавления клиентов
 * @author radik
 * @version 1.0
 */
@SpringBootTest
public class ED243Test {

    //ED243
    ED243 ed243;

    //ED1XX
    ED1XX ed1XX;

    //Номер для документа ED243
    String ED243No = "НЕ26783";

    //Наименование 1 компании
    String name1 = "Нефтяная компания";

    //Наименование 2 компании
    String name2 = "Нефтеперерабатывающая компания";

    //Клиент отправитель
    Client clientAuthor;

    //Клиент получатель
    Client clientRecipient;

    //Списко клиентов
    List<Client> clients;

    @Autowired
    RepositoryED243 repositoryED243;


    @Autowired
    RepositoryClients repositoryClients;

    @Autowired
    ComputingCenter computingCenter;

    /*
     * Тест для создания ED243 и отправки в ВЦ
     * Если ED243 c указаным номером не существует в БД
     * создается новый
     * @author radik
     * @version 1.0
     */
    @Test
    void testED243() {

        clientInitialization();


        List<ED243> ed243s;
        ed243s = repositoryED243.findED243sByEcno(ED243No);
        if(ed243s.size()>0)
        {
            ed243 = updateRequisites(ed243s.get(0));
        }
        else {
            ed243 = updateRequisites(grateED243());
        }
        repositoryED243.save(ed243);
        outCtrlCode();
    }

    /*
     * Генерация нового ED243
     * @return ED243
     * @author radik
     * @version 1.0
     */
    private ED243 grateED243() {

        ED243 ed243 = new ED243();

        ed243.setEdDate(CurentTime.getCurentTime());


        ed243.setEcno(ED243No);

        repositoryED243.save(ed243);

        return ed243;
    }

    /*
     * Метод для изменеия реквизитов ED243
     * Используется для создания или исправления ошибок
     * чтобы получить ED201 или ED208
     * @author radik
     * @version 1.0
     */
    private ED243 updateRequisites (ED243 ed243) {

        //ed243.setEdСompiler("123");

        ed243.setEdReceiver(clientRecipient.getUniqueIdentifier());

        ed243.setEdСompiler(clientAuthor.getUniqueIdentifier());

        ed243.setEdDefineRequestCode(5);

        return ed243;
    }


    /*
     * Метод для вывода результат тестирования
     * @author radik
     * @version 1.0
     */
    private void outCtrlCode()
    {
        ed1XX = computingCenter
                .primaryProcessing(ed243,clientAuthor,clientRecipient);
        if(ed1XX instanceof ED201)
        {
           ED201 ed201 = (ED201) ed1XX;

           System
            .out
             .println("Возвращена ЭС ED201 c кодом ошибки :" + ed201.getCtrlCode());
        }
        else if(ed1XX instanceof ED208)
        {
            ED208 ed208 = (ED208) ed1XX;
            System
                    .out
                    .println("Возвращена ЭС ED208 c кодом обрабоки :"
                            + ed208.getCtrlCode()+
                            " и Текст пояснения :"+ed208.getAnnotation());
            ed208 = computingCenter.stateDelivery(ed243,clientAuthor);
            System
                    .out
                    .println("Возвращена ЭС ED208 c кодом обрабоки :"
                            + ed208.getCtrlCode()+
                            " и Текст пояснения :"+ed208.getAnnotation());
        }
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
        }

        clients = repositoryClients.findClientsByName(name2);

        if(clients.size()>0) {
            clientRecipient = clients.get(0);
        }
    }
}
