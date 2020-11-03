package com.digital.epharmacy.entity.Payment;


/*Author: Matthew Pearce
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 26/10/2020
 * */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;
//Main class
@Entity
public class Payment {

    //Declaring variables using all attributes from the Payment Entity
    @Id
    private String referenceNumber;
    @NotNull(message = "Payment Status is required")
    private String paymentStatus;
    @NotNull(message = "Type of Payment is required")
    private String typeOfPayment;
    @NotNull(message = "Payment Notification is required")
    private String paymentNotification;
    @NotNull(message = "Payment total is required")
    private double paymentTotal;
    @NotNull(message = "Date is required")
    private String date;

    //declaring foreign keys, using String datatype for now)
    private String pharmacyID;

    private String userID;

    private String orderNumber;

    protected Payment (){}
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


    public String getPharmacyID() {
        return pharmacyID;
    }

    public String getUserID() {
        return userID;
    }

    public String getOrderNumber() {
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

    public String getDate() {
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
        private String date;
        private String pharmacyID;
        private String userID;
        private String orderNumber;

        //Setters for all declared variables using the Builder pattern

        //setting paymentStatus
        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        //setting pharmacyID
        public Builder setPharmacyID(String pharmacyID) {
            this.pharmacyID = pharmacyID;
            return this;
        }

        //setting userID
        public Builder setUserID(String userID) {
            this.userID = userID;
            return this;
        }

        //setting orderNumber
        public Builder setOrderNumber(String orderNumber) {
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
        public Builder setDate(String date) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(referenceNumber, payment.referenceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceNumber);
    }
}
