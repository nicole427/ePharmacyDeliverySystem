package com.digital.epharmacy.entity;
/*
 * Author: Ayabulela Mahlathini
 * Desc: Payment entity handles payments in order to complete orders and then storing the information of each order payment a user is making.
 * Date: 04/07/2020
 * */


import java.util.Date;

//Main class
public class Payment {

    //Declaring variables using all attributes from the Payment Entity
    private String paymentStatus, typeOfPayment, referenceNumber, paymentNotification;
    private double paymentTotal;
    private Date date;

    //declaring foreign keys
    private Pharmacy pharmacyID;
    private UserProfile userID;
    private Order orderNumber;

    //builder Constructor
    public Payment(Builder builder) {

        this.pharmacyID = builder.pharmacyID;
        this.userID = builder.userID;
        this.orderNumber = builder.orderNumber;
        this.paymentStatus = builder.paymentStatus;
        this.typeOfPayment = builder.typeOfPayment;
        this.referenceNumber = builder.referenceNumber;
        this.paymentNotification = builder.paymentNotification;
        this.paymentTotal = builder.paymentTotal;
        this.date = builder.date;
    }

    //getters for the declared variables


    public Pharmacy getPharmacyID() {
        return pharmacyID;
    }

    public UserProfile getUserID() {
        return userID;
    }

    public Order getOrderNumber() {
        return orderNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getPaymentNotification() {
        return paymentNotification;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public Date getDate() {
        return date;
    }

    //displaying all variables as a string
    @Override
    public String toString() {
        return "Payment{" +
                "paymentStatus='" + paymentStatus + '\'' +
                ", typeOfPayment='" + typeOfPayment + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", paymentNotification='" + paymentNotification + '\'' +
                ", paymentTotal=" + paymentTotal +
                ", date=" + date +
                ", pharmacyID=" + pharmacyID +
                ", userID=" + userID +
                ", orderNumber=" + orderNumber +
                '}';
    }

    //Inner class to implement the builder pattern
    public static class Builder{

        //Declaring variables using all attributes from the Payment Entity, same as the ones from the main class
        private String paymentStatus, typeOfPayment, referenceNumber, paymentNotification;
        private double paymentTotal;
        private Date date;
        private Pharmacy pharmacyID;
        private UserProfile userID;
        private Order orderNumber;

        //Setters for all declared variables using the Builder pattern

        //setting paymentStatus
        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        //setting pharmacyID
        public Builder setPharmacyID(Pharmacy pharmacyID) {
            this.pharmacyID = pharmacyID;
            return this;
        }

        //setting userID
        public Builder setUserID(UserProfile userID) {
            this.userID = userID;
            return this;
        }

        //setting orderNumber
        public Builder setOrderNumber(Order orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        //setting typeOfPayment
        public Builder setTypeOfPayment(String typeOfPayment) {
            this.typeOfPayment = typeOfPayment;
            return this;
        }

        //setting referenceNumber
        public Builder setReferenceNumber(String referenceNumber) {
            this.referenceNumber = referenceNumber;
            return this;
        }

        //setting paymentNotification
        public Builder setPaymentNotification(String paymentNotification) {
            this.paymentNotification = paymentNotification;
            return this;
        }

        //setting paymentTotal
        public Builder setPaymentTotal(double paymentTotal) {
            this.paymentTotal = paymentTotal;
            return this;
        }

        //setting date
        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        //Builder copy method for creating instance of Payment
        // and making a copy of it
        public Builder copy(Payment payment){

            this.pharmacyID = payment.pharmacyID;
            this.userID = payment.userID;
            this.orderNumber = payment.orderNumber;
            this.paymentStatus = payment.paymentStatus;
            this.paymentNotification = payment.paymentNotification;
            this.paymentTotal = payment.paymentTotal;
            this.typeOfPayment = payment.typeOfPayment;
            this.date = payment.date;
            this.referenceNumber = payment.referenceNumber;
            return this;
        }

        //creating an instance of this class
        public Payment build() {
            return new Payment(this);
        }
    }
}
