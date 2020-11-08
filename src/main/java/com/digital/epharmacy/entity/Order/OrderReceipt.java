package com.digital.epharmacy.entity.Order;
/*
 * Author: Keagan Tabisher
 * Desc: OrderReceipt entity composed of Order, Pharmacy, UserProfile, Payment and CatalogueItem
 *       showing the customer their final receipt.
 * Date: 04/07/2020
 *
 * Author: Nicole Hawthorne
 * Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 * and changed default constructor to protected
 * Date: 25/10/2020
 * */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
public class OrderReceipt {

    //Entity attributes
    @Id
    private int orderNumber;
    @NotNull (message = "Item Qty is required")
    private int itemQuantity;
    @NotNull(message = "Payment total is required")
    private double paymentTotal;
    private String pharmacyId;
    private String userID;
    @NotNull(message = "Item Name total is required")
    private String itemName;
    @NotNull(message = "Type of Payment total is required")
    private String typeOfPayment;
    @NotNull(message = "Date is required")
    private Date date;

    // Added default constructor for Springboot implementation.
    protected OrderReceipt() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderReceipt that = (OrderReceipt) o;
        return orderNumber == that.orderNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber);
    }
}