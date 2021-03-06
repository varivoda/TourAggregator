package model.tour;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ivan on 29.10.15.
 * Экземпляры данного класса содержат информацию о арендуемом транспорте
 */
@Entity
@Table(name = "rent_transports")
public class RentTransport {

    private int id;
    private Tour tour;
    private String companyName;
    private String companyAddress;
    private String carBrand;
    private String carNumber;
    private BigDecimal price;
    private String carCategory;
    private Date orderDate;
    private Date returnDate;
    private String locationCode;
    private String currency;

    public RentTransport() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_transport_id")
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

    @Column(name = "return_date")
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Column(name = "location_code")
    public String getLocationCode() {
        return locationCode;
    }
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    @Column(name = "car_number")
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "company_address")
    public String getCompanyAddress() {
        return companyAddress;
    }
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Column(name = "car_brand")
    public String getCarBrand() {
        return carBrand;
    }
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "car_category")
    public String getCarCategory() {
        return carCategory;
    }
    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }
}
