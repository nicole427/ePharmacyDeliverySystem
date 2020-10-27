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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDERS") //Order seems to be a reserved word, had to change to ORDERS
public class Order {

    //Entity attributes
    @Id
    @NotNull
    private String orderNumber; // (Ayabulela Mahlathini) changed order number to string so that it is auto generated in the factor;
    @NotNull(message = "UserID is required")
    private String  userID;
    private BigDecimal orderTotal;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CatalogueItem> items = new ArrayList<>(); //Ayabulela Mahlathini - for relationship with CatalogueItem Entity
    private int totalCatalogueItems;
    private String paymentType;
    private String orderStatus; //(Ayabulela Mahlathini)added orderStatus
    private String date;

    //default contructor - Ayabulela Mahlathini
    protected Order(){}

    //Builder class constructor
    private Order(Builder builder){

        this.userID =  builder.userID;
        this.orderNumber = builder.orderNumber;
        this.items = builder.items;
        this.totalCatalogueItems = builder.totalCatalogueItems;
        this.orderTotal = builder.orderTotal;
        this.paymentType = builder.paymentType;
        this.orderStatus = builder.orderStatus;
        this.date = builder.date;
    }
    //Getters for all attributes.
    public String getUserID() {
        return userID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<CatalogueItem> getItems() {
        return items;
    }

    public int getTotalCatalogueItems() {
        return totalCatalogueItems;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Object getDate() {
        return date;
    }

    //toString method that displays whats in the order class


    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", userID='" + userID + '\'' +
                ", orderTotal=" + orderTotal +
                ", items=" + items +
                ", totalCatalogueItems=" + totalCatalogueItems +
                ", paymentType='" + paymentType + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{


        private String userID;
        private String orderNumber;
        private List<CatalogueItem> items;
        private int totalCatalogueItems;
        private BigDecimal orderTotal;
        private String paymentType, orderStatus;
        private String date;

        // setting userID value using builder pattern
       public Builder setUserID(String userID){

           this.userID = userID;
           return this;
       }

       //setting orderNumber value using builder pattern
       public Builder setOrderNumber(String orderNumber){

           this.orderNumber = orderNumber;
           return this;
       }

        public Builder setItems(List<CatalogueItem> items) {
           this.items = items;
            return this;
        }

        //setting totalCatalogueItems value using builder pattern
       public Builder setTotalCatalogueItems(int totalCatalogueItems){

           this.totalCatalogueItems = totalCatalogueItems;
           return this;

       }

       //setting orderTotal value using builder pattern
       public Builder setOrderTotal(BigDecimal orderTotal){

           this.orderTotal = orderTotal;
           return this;
       }

        //setting paymentDate value using builder pattern
        public Builder setPaymentType(String paymentType){

            this.paymentType = paymentType;
            return this;
        }

        //setting orderStatus value using builder pattern
        public Builder setOrderStatus(String orderStatus){

            this.orderStatus = orderStatus;
            return this;
        }

       //setting date value using builder pattern
        public Builder setDate(String date){

           this.date = date;
           return this;
       }

        // Builder copy method that create instance of Order
       public Builder copy(Order order){

           this.userID = order.userID;
           this.orderNumber = order.orderNumber;
           this.items = order.items;
           this.totalCatalogueItems = order.totalCatalogueItems;
           this.orderTotal = order.orderTotal;
           this.paymentType = order.paymentType;
           this.orderStatus = order.orderStatus;
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
        return Objects.equals(orderNumber, order.orderNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }
}
