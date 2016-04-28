package controller.gds;

import controller.exceptions.ResidentLocationServiceException;
import model.client.DescriptionResidentLocation;
import model.tour.ResidentLocation;

import java.util.List;

/**
 * Created by ivan on 30.03.16.
 * Service for getting information about Hotels and booking it
 */
public interface ResidentLocationService {

    List<ResidentLocation> getResidentLocations(DescriptionResidentLocation drl) throws ResidentLocationServiceException;

    boolean bookResidentLocation(ResidentLocation rl) throws ResidentLocationServiceException;
}
