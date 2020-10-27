package com.digital.epharmacy.entity.Order;
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 * Author: Ayabulela Mahlathini - altered entity to connect to database
 * 25/10/2020
 * */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class OrderHistory {
    @Id
    @NotNull(message = "UserId is required")
    private String userId;
    @NotNull(message = "Total number of orders is required")
    private int totalNumberOfOrders;
    @NotNull(message = "Total Order value is required")
    private BigDecimal totalOrderValue; //Ayabulela Mahlathini - change from double to BigDecimal

    //default contructor - Ayabulela Mahlathini
    protected OrderHistory(){}

    public OrderHistory(Builder builder){
        this.userId = builder.userId;
        this.totalNumberOfOrders = builder.totalNumberOfOrders;
        this.totalOrderValue = builder.totalOrderValue;
    }

    public String getUserId() {
        return userId;
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
                "userId=" + userId +
                ", totalNumberOfOrders=" + totalNumberOfOrders +
                ", totalOrderValue=" + totalOrderValue +
                '}';
    }

    public static class Builder{
        private String userId;
        private int totalNumberOfOrders;
        private BigDecimal totalOrderValue;

        public Builder setUserId(String userId){
            this.userId = userId;
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
            this.userId = orderHistory.userId;
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
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
