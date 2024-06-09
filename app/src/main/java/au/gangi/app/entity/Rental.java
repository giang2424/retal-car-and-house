package au.gangi.app.entity;


import java.time.Duration;
import java.time.LocalDateTime;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // @Column(name = "item_id")
    // private Integer itemId;
    // @Column(name = "item_type")
    // private String itemType; // "CAR" or "HOUSE"
    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;
    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;
    // @Column(name = "total_price")
    // private double totalPrice;

    @ManyToOne
    private Car car;

    @ManyToOne
    private House house;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public double getRentalPrice() {
        double hourlyRate = 0;
        if (car != null) {
            hourlyRate = car.getRentalPrice();
        } else if (house != null) {
            hourlyRate = house.getRentalPrice();
        }
        long hours = Duration.between(startDateTime, endDateTime).toHours();
        return hours * hourlyRate;
    }

    // public void calculateTotalPrice(double pricePerHour) {
    //     long hours = ChronoUnit.HOURS.between(startDateTime, endDateTime);
    //     this.totalPrice = hours * pricePerHour;
    // }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    // public Integer getItemId() {
    //     return itemId;
    // }
    // public void setItemId(Integer itemId) {
    //     this.itemId = itemId;
    // }
    // public String getItemType() {
    //     return itemType;
    // }
    // public void setItemType(String itemType) {
    //     this.itemType = itemType;
    // }
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
    // public double getTotalPrice() {
    //     return totalPrice;
    // }
    // public void setTotalPrice(double totalPrice) {
    //     this.totalPrice = totalPrice;
    // }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public static Rental build(
            Integer id,
            // Integer itemId,
            // String itemType,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            // double totalPrice,
            Car car,
            House house,
            User user) {
        Rental item = new Rental();
        item.id = id;
        // item.itemId = itemId;
        // item.itemType = itemType;
        item.startDateTime = startDateTime;
        item.endDateTime = endDateTime;
        item.car = car;
        item.house = house;
        // item.totalPrice = totalPrice;
        item.user = user;
        return item;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int idx = -1;
        if (id != null) {
            sb.append(++idx > 0 ? ", " : "").append("id=").append(id);
        }
        // if (itemId != null) {
        //     sb.append(++idx > 0 ? ", " : "").append("address=").append(itemId);
        // }
        // if (itemType != null) {
        //     sb.append(++idx > 0 ? ", " : "").append("price=").append(itemType);
        // }
        if (startDateTime != null) {
            sb.append(++idx > 0 ? ", " : "").append("price=").append(startDateTime);
        }
        if (endDateTime != null) {
            sb.append(++idx > 0 ? ", " : "").append("price=").append(endDateTime);
        }
        // if (totalPrice != 0) {
        //     sb.append(++idx > 0 ? ", " : "").append("price=").append(totalPrice);
        // }
        if (car != null) {
            sb.append(++idx > 0 ? ", " : "").append("price=").append(car);
        }
        if (house != null) {
            sb.append(++idx > 0 ? ", " : "").append("price=").append(house);
        }
        if (user != null) {
            sb.append(++idx > 0 ? ", " : "").append("price=").append(user);
        }
        return sb.toString();
    }
    
}
