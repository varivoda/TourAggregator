package controller.gds.sabre;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ivan on 01.04.16.
 * Singleton, отвечающий за настройку сервиса для работы с GDS SABRE
 * Извлекает из файла sabreSettings.properties параметры настройки системы
 * и хранит их. Существует возможность обновления параметров метод upDate()
 */
@Singleton
@LocalBean
public class SabreProperties {

    // Заголовки для формирования запроса к сервису
    private Map<String, String> headers;

    //Основные URI для работы с различными сервисами SABRE
    private String transportationServiceURI;
    private String residentLocationServiceURI;
    private String rentTransportServiceURI;

    public SabreProperties() throws IOException {
        upDate();
    }

    // Загружает или обновляет данные из файла с параметрами в приватные поля
    public void upDate() throws IOException {

        // Доступ к файлу посредством ClassLoader и загрузка файла в виде потока
        Class saClass = SabreProperties.class;
        ClassLoader classLoader = saClass.getClassLoader();
        InputStream inputStream = SabreProperties.class.getClassLoader().getResourceAsStream("sabreSettings.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        //Утсановка полей URI
        transportationServiceURI = properties.getProperty("transportationServiceURI");
        residentLocationServiceURI = properties.getProperty("residentLocationServiceURI");
        rentTransportServiceURI = properties.getProperty("rentTransportServiceURI");

        //Если карты с заголовками нет
        if (headers == null){
            //Создаем новую хэш карту
            headers = new HashMap<String, String >();
        }else{
            //иначе чистим старую
            headers.clear();
        }

        //Добавляем параметры в карту
        headers.put("Authorization", properties.getProperty("accessToken"));
        headers.put("X-Originating-Ip", properties.getProperty("xOriginatingIp"));
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getTransportationServiceURI() {
        return transportationServiceURI;
    }

    public String getResidentLocationServiceURI() {
        return residentLocationServiceURI;
    }

    public String getRentTransportServiceURI() {
        return rentTransportServiceURI;
    }
}
