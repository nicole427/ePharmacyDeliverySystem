package com.digital.epharmacy.entity.Order;
/*
 * Author: Keagan Tabisher
 * Desc: OrderReceipt entity composed of Order, Pharmacy, UserProfile, Payment and CatalogueItem
 *       showing the customer their final receipt.
 * Date: 04/07/2020
 * */
import java.util.Date;

public class OrderReceipt {

    //Entity attributes
    private int orderNumber,itemQuantity;
    private double paymentTotal;
    private String pharmacyId,userID,itemName, typeOfPayment;
    private Date date;

    // Added default constructor for Springboot implementation.
    public OrderReceipt() {

    }

    //Builder class constructor
    private OrderReceipt(Builder builder){

        this.orderNumber = builder.orderNumber;
        this.date = builder.date;
        this.pharmacyId = builder.pharmacyId;
        this.userID = builder.userID;
        this.paymentTotal = builder.paymentTotal;
        this.typeOfPayment = builder.typeOfPayment;
        this.itemName = builder.itemName;
        this.itemQuantity = builder.itemQuantity;
    }

    //Getters for all attributes

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public String getUserID() {
        return userID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public Date getDate() {
        return date;
    }




    @Override
    // ToString method for displaying the object.
    public String toString() {
        return "OrderReceipt{" +
                "orderNumber=" + orderNumber +
                ", itemQuantity=" + itemQuantity +
                ", paymentTotal=" + paymentTotal +
                ", pharmacyId='" + pharmacyId + '\'' +
                ", userID='" + userID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", typeOfPayment='" + typeOfPayment + '\'' +
                ", date=" + date +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{
        private int orderNumber,itemQuantity;
        private double paymentTotal;
        private String pharmacyId,userID,itemName, typeOfPayment;
        private Date date;



        //setting orderNumber value using builder pattern
        public Builder setOrderNumber (int orderNumber)
        {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder settDate (Date date)
        {
            this.date = date;
            return this;
        }

        public Builder setPharmacyID(String pharmacyId)
        {
            this.pharmacyId = pharmacyId;
            return this;
        }

        public Builder setUserID(String userID)
        {
            this.userID = userID;
            return this;
        }

        public Builder setPaymentTotal(double paymentTotal)
        {
            this.paymentTotal = paymentTotal;
            return this;
        }

        public Builder setTypeOfPayment (String typeOfPayment)
        {
            this.typeOfPayment = typeOfPayment;
            return this;
        }

        public Builder setItemName (String itemName)
        {
            this.itemName = itemName;
            return this;
        }

        public Builder setItemQuantity (int itemQuantity)
        {
            this.itemQuantity = itemQuantity;
            return this;
        }





        // Builder copy method that create instance of OrderReceipt
        public Builder copy(OrderReceipt orderReceipt){

            this.orderNumber = orderReceipt.orderNumber;
            this.date = orderReceipt.date;
            this.pharmacyId = orderReceipt.pharmacyId;
            this.userID = orderReceipt.userID;
            this.paymentTotal = orderReceipt.paymentTotal;
            this.typeOfPayment = orderReceipt.typeOfPayment;
            this.itemName = orderReceipt.itemName;
            this.itemQuantity = orderReceipt.itemQuantity;

            return this;

        }

        //creating an instance of this class
        public OrderReceipt build(){return new OrderReceipt(this);}

    }


}