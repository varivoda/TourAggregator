package dao;

import controller.util.DateTimeHelper;
import controller.dao.TransportationDAO;
import controller.dao.impl.TransportationDAOImpl;
import model.tour.Transportation;
import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 21.04.16.
 */
public class TransportationDAOTest {

    private static TransportationDAO transportationDAO = new TransportationDAOImpl();

    static Transportation createTransportation() throws ParseException {

        Transportation transportation = new Transportation();

        String departureDateToStr = "2016-06-10 21:00:00";
        Date departureDateTo = DateTimeHelper.getDateTimeFromString(departureDateToStr);
        transportation.setDepartureDateTo(departureDateTo);

        String deaprtureDateFromStr = "2016-06-15 10:30:00";
        Date departureDateFrom = DateTimeHelper.getDateTimeFromString(deaprtureDateFromStr);
        transportation.setDepartureDateFrom(departureDateFrom);

        BigDecimal price = BigDecimal.valueOf(290.30);
        transportation.setPrice(price);

        String transportKindStr = "Plane";
        transportation.setTransportKind(transportKindStr);

        boolean chosen = false;
        transportation.setChosen(chosen);

        String originLocationStr = "LAX";
        transportation.setOriginLocation(originLocationStr);

        String destinationLocationStr = "FAR";
        transportation.setDestinationLocation(destinationLocationStr);

        String currencyCodeStr = "USD";
        transportation.setCurrencyCode(currencyCodeStr);

        return transportation;
    }

    @Test
    public void CRUDTest() throws ParseException {

        //Удаляем все существующие записи в таблице
        transportationDAO.deleteAll();

        //создаем эезкмпляр для тестирования
        Transportation transportation = createTransportation();

        //сохраняем в БД
        transportationDAO.persist(transportation);

        //Достаем из БД все записи
        List<Transportation> transportationList = transportationDAO.findAll();

        // проверка, что лист содержит ровно одну записать
        assertEquals(1, transportationList.size());

        Transportation transportationRet = transportationList.get(0);

        //удаляем все записи и делаем проверку, что лист записей будет пустой
        transportationDAO.deleteAll();
        transportationList = transportationDAO.findAll();
        assertEquals(0, transportationList.size());

        //Проверяем обязательные поля вернувшегося экземпляра с начальным
        assertEquals(transportation.getCurrencyCode(), transportationRet.getCurrencyCode());
        assertEquals(transportation.getDepartureDateFrom(), transportationRet.getDepartureDateFrom());
        assertEquals(transportation.getDepartureDateTo(), transportationRet.getDepartureDateTo());
        assertEquals(transportation.getTransportKind(), transportationRet.getTransportKind());
        assertEquals(transportation.isChosen(), transportationRet.isChosen());
        assertEquals(transportation.getOriginLocation(), transportationRet.getOriginLocation());
        assertEquals(transportation.getDestinationLocation(), transportationRet.getDestinationLocation());
        assertEquals(true,  transportationRet.getPrice().compareTo(transportation.getPrice()) == 0);

        System.out.println("transportation price: " + transportation.getPrice());
        System.out.println("transportation returned price: " + transportationRet.getPrice());
        BigDecimal tPirce = transportation.getPrice();
        BigDecimal tPriceRet = transportationRet.getPrice();
        System.out.println(tPirce.compareTo(tPriceRet) == 0);
    }

    @Test
    public void DeleteTest() throws ParseException {

        transportationDAO.deleteAll();

        Transportation transportation = createTransportation();

        transportationDAO.persist(transportation);

        //Достаем из БД все записи
        List<Transportation> transportationList = transportationDAO.findAll();

        // проверка, что лист содержит ровно одну записать
        assertEquals(1, transportationList.size());

        Transportation transportationRet = transportationList.get(0);

        //удаляем все записи и делаем проверку, что лист записей будет пустой
        transportationDAO.delete(transportation);
        transportationList = transportationDAO.findAll();
        assertEquals(0, transportationList.size());
    }

    //Записываем в БД 10 записей, выбираем их и удаляем
    @Test
    public void CDTestForManyEntity() throws ParseException {

        int count = 10;
        //Удаляем все существующие записи в таблице
        transportationDAO.deleteAll();

        for (int i = 0; i < count; i++) {
            //создаем эезкмпляр для тестирования
            Transportation transportation = createTransportation();

            //сохраняем в БД
            transportationDAO.persist(transportation);
        }

        //Достаем из БД все записи
        List<Transportation> transportationList = transportationDAO.findAll();

        // проверка, что лист содержит ровно одну записать
        assertEquals(count, transportationList.size());

        //удаляем все записи и делаем проверку, что лист записей будет пустой
        transportationDAO.deleteAll();
        transportationList = transportationDAO.findAll();
        assertEquals(0, transportationList.size());
    }

    @Test
    public void findWithIncorrectID(){

        Transportation transportation = transportationDAO.findById(100000);

        assertEquals(null,transportation);
    }
}
