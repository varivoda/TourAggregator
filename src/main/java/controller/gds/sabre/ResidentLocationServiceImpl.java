package controller.gds.sabre;

import controller.exceptions.ResidentLocationServiceException;
import controller.gds.ResidentLocationService;
import model.client.DescriptionResidentLocation;
import model.client.TripPreferences;
import model.tour.ResidentLocation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ivan on 30.03.16.
 */
@Stateless
@LocalBean
public class ResidentLocationServiceImpl implements ResidentLocationService {
    public List<ResidentLocation> getResidentLocations(DescriptionResidentLocation drl) throws ResidentLocationServiceException{
        System.out.println("Hello< I'm ResidentLocationService for SABRE. getResidentLocations");
        return null;
    }

    public boolean bookResidentLocation(ResidentLocation rl) throws ResidentLocationServiceException {
        System.out.println("Hello< I'm TransportationService for SABRE. bookResidentLocation");
        return false;
    }
}
