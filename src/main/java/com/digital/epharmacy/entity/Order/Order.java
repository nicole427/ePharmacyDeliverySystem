package com.digital.epharmacy.entity.Order;

/*
 * Author: Matthew Pearce
 * Desc: Order Entity composed of Order and OrderReceipt entity that stores the Order and Order Receipt of the customer
 * Date: 04/07/2020
 * */


import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

    //Entity attributes
    private int totalCatalogueItems;
    private String  userID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderNumber; // (Ayabulela Mahlathini) changed order number to string so that it is auto generated in the factory

    private double orderTotal;
    private String paymentType, orderStatus; //(Ayabulela Mahlathini)added orderStatus
    private String date;

    //default contructor - Ayabulela Mahlathini
    private Order(){}

    //Builder class constructor
    private Order(Builder builder){

        this.userID =  builder.userID;
        this.orderNumber = builder.orderNumber;
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

    public Object getDate() {
        return date;
    }

    //toString method that displays whats in the order class
    @Override
    public String toString() {
        return "Order{" +
                "userID=" + userID +
                ", orderNumber=" + orderNumber +
                ", totalCatalogueItems=" + totalCatalogueItems +
                ", orderTotal=" + orderTotal +
                ", paymentType='" + paymentType + '\'' +
                ", orderStatus=" + orderStatus +
                ", date=" + date +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{


        private String userID;
        private String orderNumber;
        private int totalCatalogueItems;
        private double orderTotal;
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

       //setting date value using builder pattern
        public Builder setDate(String date){

           this.date = date;
           return this;
       }

        // Builder copy method that create instance of Order
       public Builder copy(Order order){

           this.userID = order.userID;
           this.orderNumber = order.orderNumber;
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
}
