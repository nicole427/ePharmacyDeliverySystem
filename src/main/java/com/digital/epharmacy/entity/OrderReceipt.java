package com.digital.epharmacy.entity;

import java.util.Date;

public class OrderReceipt {

    //Entity attributes
    private int orderNumber, pharmacyId, catalogueItem, userID;
    private double paymentTotal;
    private String catalogueItemName, paymentType;
    private Date date;


    //Builder class constructor
    private OrderReceipt(Builder builder){

        this.orderNumber  = builder.orderNumber;
        this.pharmacyId = builder.pharmacyId;
        this.catalogueItem = builder.catalogueItem;
        this.userID = builder.userID;
        this.paymentTotal = builder.paymentTotal;
        this.catalogueItemName = builder.catalogueItemName;
        this.paymentType = builder.paymentType;
        this.date = builder.date;
    }

    //Getters for all attributes
    public int getOrderNumber() {
        return orderNumber;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public int getCatalogueItem() {
        return catalogueItem;
    }

    public int getUserID() {
        return userID;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public String getCatalogueItemName() {
        return catalogueItemName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public Date getDate() {
        return date;
    }

    //toString method that displays whats in the orderReceipt class
    @Override
    public String toString() {
        return "OrderReceipt{" +
                "orderNumber=" + orderNumber +
                ", pharmacyId=" + pharmacyId +
                ", catalogueItem=" + catalogueItem +
                ", userID=" + userID +
                ", paymentTotal=" + paymentTotal +
                ", catalogueItemName='" + catalogueItemName + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", date=" + date +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{

        private int orderNumber, pharmacyId, catalogueItem, userID;
        private double paymentTotal;
        private String catalogueItemName, paymentType;
        private Date date;

        //setting orderNumber value using builder pattern
        public Builder setOrderNumber(int orderNumber){

            this.orderNumber = orderNumber;
            return this;
        }

        //setting pharmacyId value using builder pattern
        public Builder setPharmacyID(int pharmacyId){

            this.pharmacyId = pharmacyId;
            return this;
        }

        //setting catalogueItem value using builder pattern
        public Builder setCatalogueItem(int catalogueItem){

            this.catalogueItem = catalogueItem;
            return this;
        }

        //setting userID value using builder pattern
        public Builder setUserID(int userID){

            this.userID = userID;
            return this;
        }

        //setting paymentTotal value using builder pattern
        public Builder setPaymentTotal(double paymentTotal){

            this.paymentTotal = paymentTotal;
            return this;
        }

        //setting catalogueItemName value using builder pattern
        public Builder setCatalogueItemName(String catalogueItemName){

            this.catalogueItemName = catalogueItemName;
            return this;
        }

        //setting paymentType value using builder pattern
        public Builder setPaymentType(String paymentType){

            this.paymentType = paymentType;
            return this;
        }

        //setting date value using builder pattern
        public Builder setDate(Date date){

            this.date = date;
            return this;
        }

        // Builder copy method that create instance of OrderReceipt
        public Builder copy(OrderReceipt orderReceipt){

            this.orderNumber = orderReceipt.orderNumber;
            this.pharmacyId = orderReceipt.pharmacyId;
            this.catalogueItem = orderReceipt.catalogueItem;
            this.userID = orderReceipt.userID;
            this.paymentTotal = orderReceipt.paymentTotal;
            this.catalogueItemName = orderReceipt.catalogueItemName;
            this.paymentType = orderReceipt.paymentType;
            this.date = orderReceipt.date;
            return this;

        }

        //creating an instance of this class
        public OrderReceipt build(){return new OrderReceipt(this);}

    }


}
