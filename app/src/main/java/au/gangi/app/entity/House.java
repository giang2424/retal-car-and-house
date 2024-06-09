package au.gangi.app.entity;

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
@Table(name = "houses")

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "address")
    String address;
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
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    public static House build(
            Integer id,
            String address,
            double rentalPrice,
            boolean availability) {
        House item = new House();
        item.id = id;
        item.address = address;
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
        if (address != null) {
            sb.append(++idx > 0 ? ", " : "").append("address=").append(address);
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



