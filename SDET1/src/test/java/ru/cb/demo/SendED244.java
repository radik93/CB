package ru.cb.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cb.demo.interfaces.ED244Maker;
import ru.cb.demo.interfaces.grud.ClientModelsRepositoris;
import ru.cb.demo.models.Client;
import ru.cb.demo.models.ED208;
import ru.cb.demo.utils.CodeAck;

import java.util.List;

/*
 * Тестируем создание проверку и отправку ED244
 * @author radik
 * @version 1.0
 */
@SpringBootTest
public class SendED244 {


    @Autowired
    ED244Maker ed244Maker;

    @Autowired
    ClientModelsRepositoris clientModelsRepositoris;

    int edReceiver  = 654;

    int edAuthor  = 659;

    boolean delivered=true;

    List<Client> clients;

    ED208 ed208;

    String dick = "Проверка реквизитов";

    @Test
    public void sendED244() {

      clients =  clientModelsRepositoris.findClientsByEdReceiver(edReceiver);

      if(clients.size()>0) {
          ed208 = ed244Maker.sendED244(CodeAck.getCode(dick),
                  edReceiver, edAuthor, delivered, clients.get(0));
          System.out.println("CtrlCode :"+ed208.getCtrlCode());
      }
    }


}
