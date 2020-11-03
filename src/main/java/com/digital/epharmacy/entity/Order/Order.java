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
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Order {

    //Entity attributes
    @Id
    @Column(name = "id")
    private String orderNumber; // (Ayabulela Mahlathini) changed order number to string so that it is auto generated in the factory
    @Column(precision=10, scale=2)
    private double orderTotal;
    @NotNull(message = "Total Items is required")
    private int totalCatalogueItems;
    @NotBlank(message = "Payment type is required")
    private String paymentType;
    @NotBlank(message = "Order Status is required")
    private String orderStatus; //(Ayabulela Mahlathini)added orderStatus

    //default contructor - Ayabulela Mahlathini
    protected Order(){}

    //Builder class constructor
    private Order(Builder builder){

        this.orderNumber = builder.orderNumber;
        this.totalCatalogueItems = builder.totalCatalogueItems;
        this.orderTotal = builder.orderTotal;
        this.paymentType = builder.paymentType;
        this.orderStatus = builder.orderStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public int getTotalCatalogueItems() {
        return totalCatalogueItems;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    //toString method that displays whats in the order class
    @Override
    public String toString() {
        return "Order{" +
                ", orderNumber=" + orderNumber +
                ", totalCatalogueItems=" + totalCatalogueItems +
                ", orderTotal=" + orderTotal +
                ", paymentType='" + paymentType + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{

        private String orderNumber;
        private int totalCatalogueItems;
        private double orderTotal;
        private String paymentType, orderStatus;

        //setting orderNumber value using builder pattern
        public Builder setOrderNumber(String orderNumber){

            this.orderNumber = orderNumber;
            return this;
        }

        //setting totalCatalogueItems value using builder pattern
        public Builder setTotalCatalogueItems(int totalCatalogueItems){

            this.totalCatalogueItems = totalCatalogueItems;
            return this;

        }

        //setting orderTotal value using builder pattern
        public Builder setOrderTotal(double orderTotal){

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


        // Builder copy method that create instance of Order
        public Builder copy(Order order){

            this.orderNumber = order.orderNumber;
            this.totalCatalogueItems = order.totalCatalogueItems;
            this.orderTotal = order.orderTotal;
            this.paymentType = order.paymentType;
            this.orderStatus = order.orderStatus;

            return this;
        }

        //creating an instance of this class
        public Order build(){return new Order(this);}
    }
}
