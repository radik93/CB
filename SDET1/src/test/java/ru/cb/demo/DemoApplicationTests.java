package ru.cb.demo;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cb.demo.interfaces.AddClient;
import ru.cb.demo.interfaces.VCControl;
import ru.cb.demo.models.Client;
import ru.cb.demo.models.ED201;
import ru.cb.demo.models.ED243;

@SpringBootTest
class DemoApplicationTests {


    Client client1;

    Client client2;

    String comName1="АО ТПК";

    String comName2="АО СВТНП";

    int INN1 = 1612345698;

    int INN2 = 1612345698;

    int BIK1 = 962345698;

    int BIK2 = 912345698;

    int PS1  = 12387654;

    int PS2  = 12387654;

    int edReceiver1  = 654;

    int edReceiver2  = 659;

    ED243 ed243;

    @Autowired
    AddClient addClient;

    @Autowired
    VCControl vcControl;

    public void grateClient() {
        client1=new Client(comName1,INN1,PS1,BIK1,edReceiver1);

        client2=new Client(comName2,INN2,PS2,BIK2,edReceiver2);

    }

    @Test
    public void contextLoads() {
        grateClient();
        addClient.addNewClient(client1);
        addClient.addNewClient(client2);
    }

    @Test
    public void sendУВ243() {
        ED201 ed201=vcControl.performСontrol(ed243);
    }


}
