package com.digital.epharmacy.entity.Order;

/*
 * Author: Matthew Pearce
 * Desc: Order Entity composed of Order and OrderReceipt entity that stores the Order and Order Receipt of the customer
 * Date: 04/07/2020
 * */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 *
 * Author: Ayabulela Mahlathini - altered entity to connect to database
 * 25/10/2020
 *
 * */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.User.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "orders") //Order seems to be a reserved word, had to change to ORDERS
public class Order {

    //Entity attributes
    @Id
    @NotNull
    private String order_number; // (Ayabulela Mahlathini) changed order number to string so that it is auto generated in the factor;
    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserProfile user;
    private BigDecimal order_total;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CatalogueItem> items = new HashSet<>(); //Ayabulela Mahlathini - for relationship with CatalogueItem Entity
    private int total_catalogue_items;
    private String payment_type;
    private String order_status; //(Ayabulela Mahlathini)added order_status
    private String date;

    //default contructor - Ayabulela Mahlathini
    protected Order(){}

    //Builder class constructor
    private Order(Builder builder){

        this.user =  builder.user;
        this.order_number = builder.order_number;
        this.items = builder.items;
        this.total_catalogue_items = builder.total_catalogue_items;
        this.order_total = builder.order_total;
        this.payment_type = builder.payment_type;
        this.order_status = builder.order_status;
        this.date = builder.date;
    }
    //Getters for all attributes.
    public UserProfile getUser() {
        return user;
    }

    public String getOrderNumber() {
        return order_number;
    }

    public Set<CatalogueItem> getItems() {
        return items;
    }

    public int getTotalCatalogueItems() {
        return total_catalogue_items;
    }

    public BigDecimal getOrderTotal() {
        return order_total;
    }

    public String getPaymentType() {
        return payment_type;
    }

    public String getOrderStatus() {
        return order_status;
    }

    public Object getDate() {
        return date;
    }

    //toString method that displays whats in the order class


    @Override
    public String toString() {
        return "Order{" +
                "order_number='" + order_number + '\'' +
                ", user=" + user +
                ", order_total=" + order_total +
                ", items=" + items +
                ", total_catalogue_items=" + total_catalogue_items +
                ", payment_type='" + payment_type + '\'' +
                ", order_status='" + order_status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{


        private UserProfile user;
        private String order_number;
        private Set<CatalogueItem> items;
        private int total_catalogue_items;
        private BigDecimal order_total;
        private String payment_type, order_status;
        private String date;

        // setting user value using builder pattern
        public Builder setUser(UserProfile user){

            this.user = user;
            return this;
        }

        //setting order_number value using builder pattern
        public Builder setOrderNumber(String order_number){

            this.order_number = order_number;
            return this;
        }

        public Builder setItems(Set<CatalogueItem> items) {
            this.items = items;
            return this;
        }

        //setting total_catalogue_items value using builder pattern
        public Builder setTotalCatalogueItems(int total_catalogue_items){

            this.total_catalogue_items = total_catalogue_items;
            return this;

        }

        //setting order_total value using builder pattern
        public Builder setOrderTotal(BigDecimal order_total){

            this.order_total = order_total;
            return this;
        }

        //setting paymentDate value using builder pattern
        public Builder setPaymentType(String payment_type){

            this.payment_type = payment_type;
            return this;
        }

        //setting order_status value using builder pattern
        public Builder setOrderStatus(String order_status){

            this.order_status = order_status;
            return this;
        }

        //setting date value using builder pattern
        public Builder setDate(String date){

            this.date = date;
            return this;
        }

        // Builder copy method that create instance of Order
        public Builder copy(Order order){

            this.user = order.user;
            this.order_number = order.order_number;
            this.items = order.items;
            this.total_catalogue_items = order.total_catalogue_items;
            this.order_total = order.order_total;
            this.payment_type = order.payment_type;
            this.order_status = order.order_status;
            this.date = order.date;

            return this;
        }

        //creating an instance of this class
        public Order build(){return new Order(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return total_catalogue_items == order.total_catalogue_items &&
                order_number.equals(order.order_number) &&
                user.equals(order.user) &&
                Objects.equals(order_total, order.order_total) &&
                Objects.equals(items, order.items) &&
                Objects.equals(payment_type, order.payment_type) &&
                Objects.equals(order_status, order.order_status) &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_number, user, order_total, items, total_catalogue_items, payment_type, order_status, date);
    }
}