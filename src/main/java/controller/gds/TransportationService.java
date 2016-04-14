package controller.gds;

import controller.exceptions.TransportationServiceException;
import model.client.DescriptionTransportation;
import model.tour.Transportation;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 * Интерфейс, предоставляющий механизм поиска перелетов по данным, содержащимся в DescriptionTransportation
 * Также интерфейс позволяет осуществлять заказ необходимого контента по идентификатору
 */

public interface TransportationService {

    List<Transportation> getTransportationsFromDescriptionTransportation(DescriptionTransportation descriptionTransportation) throws TransportationServiceException;

    boolean bookTransportation(Transportation transportation) throws TransportationServiceException;

}
