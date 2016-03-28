/**
 * Created by ivan on 16.12.15.
 */
import controller.dao.impl.DaoClientImpl;
import model.client.Client;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CRUDClientTests {



//    @Test
//    public void insertSelectByIdTest(){
//
//        Client newClient = new Client();
//        newClient.setEmail("email@yandex.ru");
//        newClient.setFullName("Ivanov Ivan Ivanovich");
//        newClient.setPassword("Password");
//
//        DaoClientImpl cs = new DaoClientImpl();
//        cs.persist(newClient);
//
//        Client selClient = cs.findById(newClient.getClientId());
//
//        assertEquals(true, selClient != null);
//
//        System.out.println(selClient.getClientId());
//        assertEquals(newClient.getEmail(),selClient.getEmail());
//        assertEquals(newClient.getFullName(),selClient.getFullName());
//        assertEquals(newClient.getPassword(),selClient.getPassword());
//
//
//        cs.deleteById(newClient);
//
//        Client selClient2 = cs.findById(newClient.getClientId());
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

        DaoClientImpl cs = new DaoClientImpl();
        cs.persist(newClient);

        Client selClient = cs.findByEmail(newClient.getEmail());
        Client sel3Client = cs.findById(selClient.getId());

        assertEquals(true, selClient != null);

        System.out.println(selClient.getId());
        assertEquals(newClient.getEmail(),selClient.getEmail());
        assertEquals(newClient.getFullName(),selClient.getFullName());
        assertEquals(newClient.getPassword(),selClient.getPassword());

        cs.delete(selClient);

        Client selClient2 = cs.findByEmail(newClient.getEmail());

        assertEquals(null,selClient2);

    }
}
