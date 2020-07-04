package com.digital.epharmacy.entity;

import java.util.Date;

public class OrderReceipt {

    //Entity attributes
    private Order orderNumber, date;
    private Pharmacy pharmacyId;
    private UserProfile userID;
    private Payment paymentTotal,typeOfPayment;
    private CatalogueItem itemName,itemQuantity;




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


    public Order getOrderNumber() {
        return orderNumber;
    }

    public Order getDate() {
        return date;
    }

    public Pharmacy getPharmacyId() {
        return pharmacyId;
    }

    public UserProfile getUserID() {
        return userID;
    }

    public Payment getPaymentTotal() {
        return paymentTotal;
    }

    public Payment getTypeOfPayment() {
        return typeOfPayment;
    }

    public CatalogueItem getItemName() {
        return itemName;
    }

    public CatalogueItem getItemQuantity() {
        return itemQuantity;
    }

    //toString method that displays whats in the orderReceipt class
    @Override
    public String toString() {
        return "OrderReceipt{" +
                "orderNumber=" + orderNumber +
                ", date=" + date +
                ", pharmacyId=" + pharmacyId +
                ", userID=" + userID +
                ", paymentTotal=" + paymentTotal +
                ", typeOfPayment=" + typeOfPayment +
                ", itemName=" + itemName +
                ", itemQuantity=" + itemQuantity +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder{

        private Order orderNumber, date;
        private Pharmacy pharmacyId;
        private UserProfile userID;
        private Payment paymentTotal,typeOfPayment;
        private CatalogueItem itemName,itemQuantity;

        //setting orderNumber value using builder pattern
        public Builder setOrderNumber (Order orderNumber)
        {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder settDate (Order date)
        {
            this.date = date;
            return this;
        }

        public Builder setPharmacyID(Pharmacy pharmacyId)
        {
            this.pharmacyId = pharmacyId;
            return this;
        }

        public Builder setUserID(UserProfile userID)
        {
            this.userID = userID;
            return this;
        }

        public Builder setPaymentTotal(Payment paymentTotal)
        {
            this.paymentTotal = paymentTotal;
            return this;
        }

        public Builder setTypeOfPayment (Payment typeOfPayment)
        {
            this.typeOfPayment = typeOfPayment;
            return this;
        }

        public Builder setItemName (CatalogueItem itemName)
        {
            this.itemName = itemName;
            return this;
        }

        public Builder setItemQuantity (CatalogueItem itemQuantity)
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