package model.client;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ivan on 02.04.16.
 */
public class DescriptionTransportation {

    private String locationCountry;
    private String originCode;
    private String destinationCode;
    private Date departDate;
    private Date arrivalDate;
    private int lengthOfStay;
    private BigDecimal minFare;
    private BigDecimal maxFare;
    private String pointOfSaleCode;

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public DescriptionTransportation() {
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public BigDecimal getMinFare() {
        return minFare;
    }

    public void setMinFare(BigDecimal minFare) {
        this.minFare = minFare;
    }

    public BigDecimal getMaxFare() {
        return maxFare;
    }

    public void setMaxFare(BigDecimal maxFare) {
        this.maxFare = maxFare;
    }

    public String getPointOfSaleCode() {
        return pointOfSaleCode;
    }

    public void setPointOfSaleCode(String pointOfSaleCode) {
        this.pointOfSaleCode = pointOfSaleCode;
    }
}
