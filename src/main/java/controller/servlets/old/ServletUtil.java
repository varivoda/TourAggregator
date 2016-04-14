package controller.servlets.old;

import model.TourContentData;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ivan on 06.04.16.
 */
class ServletUtil {

     static HttpServletRequest setTourContentDataInRequest(HttpServletRequest req){

        req.setAttribute("transportKinds", TourContentData.getTransportKindsAsArray());
        req.setAttribute("hotelKinds", TourContentData.getHotelKindsAsArray());
        req.setAttribute("tripDocumentTypes", TourContentData.getTripDocumentsTypesAsArray());

        return req;
    }
}
