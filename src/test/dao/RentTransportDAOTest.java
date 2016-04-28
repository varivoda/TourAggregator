package dao;

import controller.util.DateTimeHelper;
import controller.dao.RentTransportDAO;
import controller.dao.impl.RentTransportDAOImpl;
import model.tour.RentTransport;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ivan on 21.04.16.
 */
public class RentTransportDAOTest {

    private static RentTransportDAO rentTransportDAO = new RentTransportDAOImpl();

    static RentTransport createSimplyRentTransport() throws ParseException {

        RentTransport rentTransport = new RentTransport();

        BigDecimal pricePerDay = BigDecimal.valueOf(50.50);
        rentTransport.setPrice(pricePerDay);

        String orderDateStr = "2016-06-10 15:00:00";
        Date orderDate = DateTimeHelper.getDateTimeFromString(orderDateStr);
        rentTransport.setOrderDate(orderDate);

        String returnDateStr = "2016-06-15 09:00:00";
        Date returnDate = DateTimeHelper.getDateTimeFromString(returnDateStr);
        rentTransport.setReturnDate(returnDate);

        String locationCodeStr = "LAX";
        rentTransport.setLocationCode(locationCodeStr);

        return rentTransport;
    }

    @Test
    public void CRUDTest() throws ParseException {

        //Удаляем все существующие записи в таблице
        rentTransportDAO.deleteAll();

        //создаем эезкмпляр для тестирования
        RentTransport rentTransport = createSimplyRentTransport();

        //сохраняем в БД
        rentTransportDAO.persist(rentTransport);

        //Достаем из БД все записи
        List<RentTransport> rentTransportList = rentTransportDAO.findAll();

        // проверка, что лист содержит ровно одну записать
        assertEquals(1, rentTransportList.size());

        RentTransport rentTransportRet = rentTransportList.get(0);

        //удаляем все записи и делаем проверку, что лист записей будет пустой
        rentTransportDAO.deleteAll();
        rentTransportList = rentTransportDAO.findAll();
        assertEquals(0, rentTransportList.size());

        //Проверяем обязательные поля вернувшегося экземпляра с начальным
        assertEquals(true,  rentTransportRet.getPrice().compareTo(rentTransport.getPrice()) == 0);
        assertEquals(rentTransport.getOrderDate() , rentTransportRet.getOrderDate());
        assertEquals(rentTransport.getReturnDate() , rentTransportRet.getReturnDate());
        assertEquals(rentTransport.getLocationCode() , rentTransportRet.getLocationCode());
    }

    @Test
    public void DeleteTest() throws ParseException {
        //Удаляем все существующие записи в таблице
        rentTransportDAO.deleteAll();

        //создаем эезкмпляр для тестирования
        RentTransport rentTransport = createSimplyRentTransport();

        //сохраняем в БД
        rentTransportDAO.persist(rentTransport);

        //Достаем из БД все записи
        List<RentTransport> rentTransportList = rentTransportDAO.findAll();

        // проверка, что лист содержит ровно одну записать
        assertEquals(1, rentTransportList.size());

        RentTransport rentTransportRet = rentTransportList.get(0);

        //удаляем все записи и делаем проверку, что лист записей будет пустой
        rentTransportDAO.delete(rentTransport);
        rentTransportList = rentTransportDAO.findAll();
        assertEquals(0, rentTransportList.size());
    }

    @Test
    public void CDForManyEntities() throws ParseException {

        //Удаляем все существующие записи в таблице
        rentTransportDAO.deleteAll();

        int count = 10;

        for (int i = 0; i < count; i++) {
            //создаем эезкмпляр для тестирования
            RentTransport rentTransport = createSimplyRentTransport();

            //сохраняем в БД
            rentTransportDAO.persist(rentTransport);
        }

        //Достаем из БД все записи
        List<RentTransport> rentTransportList = rentTransportDAO.findAll();

        // проверка, что лист содержит ровно одну записать
        assertEquals(count, rentTransportList.size());

        //удаляем все записи и делаем проверку, что лист записей будет пустой
        rentTransportDAO.deleteAll();
        rentTransportList = rentTransportDAO.findAll();
        assertEquals(0, rentTransportList.size());


    }
}
