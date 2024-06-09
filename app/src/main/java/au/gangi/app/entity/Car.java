package au.gangi.app.entity;

// import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "model")
    private String model;
    @Column(name = "brand")
    private String brand;
    @Column(name = "rentalPrice")
    private double rentalPrice;
    @Column(name = "availability")
    private boolean availability;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public double getRentalPrice() {
        return rentalPrice;
    }
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    
    public boolean getAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public static Car build(
            Integer id,
            String model,
            String brand,
            double rentalPrice,
            boolean availability) {
        Car item = new Car();
        item.id = id;
        item.model = model;
        item.brand = brand;
        item.rentalPrice = rentalPrice;
        item.availability = availability;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int idx = -1;
        if (id != null) {
            sb.append(++idx > 0 ? ", " : "").append("id=").append(id);
        }
        if (model != null) {
            sb.append(++idx > 0 ? ", " : "").append("code=").append(model);
        }
        if (brand != null) {
            sb.append(++idx > 0 ? ", " : "").append("brand=").append(brand);
        }
        if (rentalPrice != 0) {
            sb.append(++idx > 0 ? ", " : "").append("price=").append(rentalPrice);
        }
        if (availability) {
            sb.append(++idx > 0 ? ", " : "").append("availability=").append(availability);
        }
        return sb.toString();
    }
}

