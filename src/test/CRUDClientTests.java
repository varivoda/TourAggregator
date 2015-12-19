/**
 * Created by ivan on 16.12.15.
 */
import com.var.agregator.dao.ClientService;
import com.var.agregator.dto.client.Client;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CRUDClientTests {



//    @Test
//    public void insertSelectByIdTest(){
//        Client newClient = new Client();
//        newClient.setEmail("email@yandex.ru");
//        newClient.setFullName("Ivanov Ivan Ivanovich");
//        newClient.setPassword("Password");
//
////        newClient.setClientId(4);
//
//        ClientService.persist(newClient);
//
//        Client selClient = ClientService.findById(newClient.getClientId());
//
//        assertEquals(true, selClient != null);
//
////        assertEquals(newClient.getClientId(),selClient.getClientId());
//        System.out.println(selClient.getClientId());
//        assertEquals(newClient.getEmail(),selClient.getEmail());
//        assertEquals(newClient.getFullName(),selClient.getFullName());
//        assertEquals(newClient.getPassword(),selClient.getPassword());
//
//
//        ClientService.delete(newClient);
//
//        Client selClient2 = ClientService.findById(newClient.getClientId());
//
//        assertEquals(null,selClient2);
//
//    }

    @Test
    public void insertSelectByEmailTest(){
        Client newClient = new Client();
        newClient.setEmail("email@yandex.ru");
        newClient.setFullName("Ivanov Ivan Ivanovich");
        newClient.setPassword("Password");

        ClientService cs = new ClientService();

        Client selClient = cs.findByEmail(newClient.getEmail());

        assertEquals(true, selClient != null);

//        assertEquals(newClient.getClientId(),selClient.getClientId());
        System.out.println(selClient.getClientId());
        assertEquals(newClient.getEmail(),selClient.getEmail());
        assertEquals(newClient.getFullName(),selClient.getFullName());
        assertEquals(newClient.getPassword(),selClient.getPassword());



        cs.delete(selClient);

        Client selClient2 = cs.findByEmail(newClient.getEmail());

        assertEquals(null,selClient2);

    }
}
