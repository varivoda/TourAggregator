package model.tour;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * Created by ivan on 29.10.15.
 */
@Entity
@Table(name = "transportations")
public class Transportation {

    private int id;
    private Tour tour;
    private String transportKind;
    private String airlineCode;
    private String departureAddressTo;
    private String departureAddressFrom;
    private Date departureDateTo;
    private Date departureDateFrom;
    private BigDecimal price;
    private boolean chosen;
    private String destinationLocation;
    private String originLocation;
    private String currencyCode;

    public Transportation() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportation_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "transportation_kind")
    public String getTransportKind() {
        return transportKind;
    }
    public void setTransportKind(String transportKind) {
        this.transportKind = transportKind;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tour_id")
    public Tour getTour() {
        return tour;
    }
    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Column(name = "airline_code")
    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @Column(name = "departure_address_to")
    public String getDepartureAddressTo() {
        return departureAddressTo;
    }
    public void setDepartureAddressTo(String departureAddressTo) {
        this.departureAddressTo = departureAddressTo;
    }

    @Column(name = "departure_address_from")
    public String getDepartureAddressFrom() {
        return departureAddressFrom;
    }
    public void setDepartureAddressFrom(String departureAddressFrom) {
        this.departureAddressFrom = departureAddressFrom;
    }

    @Column(name = "currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Column(name = "destination_location")
    public String getDestinationLocation() {
        return destinationLocation;
    }
    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    @Column(name = "origin_location")
    public String getOriginLocation() {
        return originLocation;
    }
    public void setOriginLocation(String originLocation) {
        this.originLocation = originLocation;
    }

    @Column(name = "chosen")
    public boolean isChosen() {
        return chosen;
    }
    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date_to")
    public Date getDepartureDateTo() {
        return departureDateTo;
    }
    public void setDepartureDateTo(Date departureDateTo) {
        this.departureDateTo = departureDateTo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_date_from")
    public Date getDepartureDateFrom() {
        return departureDateFrom;
    }
    public void setDepartureDateFrom(Date departureDateFrom) {
        this.departureDateFrom = departureDateFrom;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
