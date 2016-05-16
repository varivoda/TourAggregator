package model.tour;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ivan on 29.10.15.
 * Класс предназначен для хранения иформации о месте проживания
 */
@Entity
@Table(name = "resident_locations")
public class ResidentLocation {

    private int id;
    private Tour tour;
    private String hotelKind;
    private String hotelName;
    private String hotelAddress;
    private BigDecimal price;
    private Date orderDate;
    private Date departureDate;
    private String locationCode;
    private String currency;

    public ResidentLocation() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_location_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "departure_date")
    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Column(name = "location_code")
    public String getLocationCode() {
        return locationCode;
    }
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    @Column(name = "hotel_kind")
    public String getHotelKind() {
        return hotelKind;
    }
    public void setHotelKind(String hotelKind) {
        this.hotelKind = hotelKind;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "hotel_name")
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Column(name = "hotel_address")
    public String getHotelAddress() {
        return hotelAddress;
    }
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}
