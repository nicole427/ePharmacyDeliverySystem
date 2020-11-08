package com.digital.epharmacy.entity.Order;
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 * Author: Ayabulela Mahlathini - altered entity to connect to database
 * 25/10/2020
 * */
import com.digital.epharmacy.entity.User.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class OrderHistory implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull(message = "User is required")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "user_id")
    private UserProfile user;
    @NotNull(message = "Total number of orders is required")
    private int totalNumberOfOrders;
    @NotNull(message = "Total Order value is required")
    private BigDecimal totalOrderValue; //Ayabulela Mahlathini - change from double to BigDecimal

    //default contructor - Ayabulela Mahlathini
    protected OrderHistory(){}

    public OrderHistory(Builder builder){
        this.id = builder.id;
        this.user = builder.user;
        this.totalNumberOfOrders = builder.totalNumberOfOrders;
        this.totalOrderValue = builder.totalOrderValue;
    }

    public String getId() {
        return id;
    }

    public UserProfile getUser() {
        return user;
    }

    public int getTotalNumberOfOrders() {
        return totalNumberOfOrders;
    }

    public BigDecimal getTotalOrderValue() {
        return totalOrderValue;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "user=" + user +
                ", totalNumberOfOrders=" + totalNumberOfOrders +
                ", totalOrderValue=" + totalOrderValue +
                '}';
    }

    public static class Builder{
        private String id;
        private UserProfile user;
        private int totalNumberOfOrders;
        private BigDecimal totalOrderValue;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUser(UserProfile user){
            this.user = user;
            return this;
        }

        public Builder setTotalNumberOfOrders(int totalNumberOfOrders){
            this.totalNumberOfOrders= totalNumberOfOrders;
            return this;
        }

        public Builder setTotalOrderValue(BigDecimal totalOrderValue){
            this.totalOrderValue = totalOrderValue;
            return this;
        }

        public Builder copy(OrderHistory orderHistory){
            this.id = orderHistory.id;
            this.user = orderHistory.user;
            this.totalNumberOfOrders = orderHistory.totalNumberOfOrders;
            this.totalOrderValue= orderHistory.totalOrderValue;
            return this;
        }

        public OrderHistory build(){
            return  new OrderHistory(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHistory that = (OrderHistory) o;
        return id.equals(that.id) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}