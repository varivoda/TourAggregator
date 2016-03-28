package model.tour;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ivan on 29.10.15.
 */
@Entity
@Table(name = "resident_locations")
public class ResidentLocation {

    private int id;
    private Tour tour;
    private String hotelKind;
    private String hotelName;
    private String hotelAddress;
    private BigDecimal pricePerDay;


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

    @Column(name = "hotel_kind")
    public String getHotelKind() {
        return hotelKind;
    }
    public void setHotelKind(String hotelKind) {
        this.hotelKind = hotelKind;
    }

    @Column(name = "price_per_day")
    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
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
