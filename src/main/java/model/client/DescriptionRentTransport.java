package model.client;

import java.util.Date;

/**
 * Created by ivan on 25.04.16.
 */
public class DescriptionRentTransport {

    private Date pickUpDateTime;
    private Date returnDateTime;
    private String locationCode;

    public DescriptionRentTransport() {
    }

    public Date getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(Date pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public Date getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(Date returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}
