package model.client;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ivan on 27.04.16.
 * Класс предназначенный для описания места жительства
 */
public class DescriptionResidentLocation {

    private Date orderDate;
    private Date departureDate;
    private String locationCode;
    private BigDecimal maxFare;

    public DescriptionResidentLocation() {
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public BigDecimal getMaxFare() {
        return maxFare;
    }

    public void setMaxFare(BigDecimal maxFare) {
        this.maxFare = maxFare;
    }
}
