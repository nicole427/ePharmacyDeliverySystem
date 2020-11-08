package com.digital.epharmacy.entity.Order;
/*
 * Author: Keagan Tabisher
 * Desc: OrderReceipt entity composed of Order, Pharmacy, UserProfile, Payment and CatalogueItem
 *       showing the customer their final receipt.
 * String: 04/07/2020
 *
 * Author: Nicole Hawthorne
 * Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 * and changed default constructor to protected
 * String: 25/10/2020
 * */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class OrderReceipt {

    //Ayabulela Mahlathini - Fixed relationships
    //Entity attributes
    @Id
    @Column(name = "receipt_number")
    private String receipt_number;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "order_number")
    private Order order;
    @NotNull(message = "Item Qty is required")
    private int itemQuantity;
    @NotNull(message = "Payment total is required")
    private BigDecimal paymentTotal;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "id")
    private Pharmacy pharmacy;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "user_id")
    private UserProfile user;
    @NotNull(message = "Items are required")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CatalogueItem> items = new HashSet<>();
    @NotNull(message = "Type of Payment total is required")
    private String typeOfPayment;
    @NotNull(message = "String is required")
    private String date;

    // Added default constructor for Springboot implementation.
    protected OrderReceipt() {

    }

    //Builder class constructor
    private OrderReceipt(Builder builder) {

        this.receipt_number = builder.receipt_number;
        this.order = builder.order;
        this.date = builder.date;
        this.pharmacy = builder.pharmacy;
        this.user = builder.user;
        this.paymentTotal = builder.paymentTotal;
        this.typeOfPayment = builder.typeOfPayment;
        this.items = builder.items;
        this.itemQuantity = builder.itemQuantity;
    }

    //Getters for all attributes


    public String getReceipt_number() {
        return receipt_number;
    }

    public Order getOrder() {
        return order;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public UserProfile getUser() {
        return user;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public BigDecimal getPaymentTotal() {
        return paymentTotal;
    }


    public Set<CatalogueItem> getItems() {
        return items;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public String getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "OrderReceipt{" +
                "receipt_number='" + receipt_number + '\'' +
                ", order=" + order +
                ", itemQuantity=" + itemQuantity +
                ", paymentTotal=" + paymentTotal +
                ", pharmacy=" + pharmacy +
                ", user=" + user +
                ", items='" + items + '\'' +
                ", typeOfPayment='" + typeOfPayment + '\'' +
                ", date=" + date +
                '}';
    }

    //Builder class to implement the builder pattern
    public static class Builder {

        private String receipt_number;
        private Order order;
        private int itemQuantity;
        private BigDecimal paymentTotal;
        private Pharmacy pharmacy;
        private UserProfile user;
        private Set<CatalogueItem> items;
        private String typeOfPayment;
        private String date;


        //setting orderNumber value using builder pattern


        public Builder setReceipt_number(String receipt_number) {
            this.receipt_number = receipt_number;
            return this;
        }


        public Builder settString(String date) {
            this.date = date;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setPharmacy(Pharmacy pharmacy) {
            this.pharmacy = pharmacy;
            return this;
        }

        public Builder setUser(UserProfile user) {
            this.user = user;
            return this;
        }

        public Builder setPaymentTotal(BigDecimal paymentTotal) {
            this.paymentTotal = paymentTotal;
            return this;
        }

        public Builder setTypeOfPayment(String typeOfPayment) {
            this.typeOfPayment = typeOfPayment;
            return this;
        }

        public Builder setItems(Set<CatalogueItem> items) {
            this.items = items;
            return this;
        }

        public Builder setItemQuantity(int itemQuantity) {
            this.itemQuantity = itemQuantity;
            return this;
        }


        // Builder copy method that create instance of OrderReceipt
        public Builder copy(OrderReceipt orderReceipt) {

            this.receipt_number = orderReceipt.receipt_number;
            this.order = orderReceipt.order;
            this.date = orderReceipt.date;
            this.pharmacy = orderReceipt.pharmacy;
            this.user = orderReceipt.user;
            this.paymentTotal = orderReceipt.paymentTotal;
            this.typeOfPayment = orderReceipt.typeOfPayment;
            this.items = orderReceipt.items;
            this.itemQuantity = orderReceipt.itemQuantity;

            return this;

        }

        //creating an instance of this class
        public OrderReceipt build() {
            return new OrderReceipt(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderReceipt that = (OrderReceipt) o;
        return itemQuantity == that.itemQuantity &&
                receipt_number.equals(that.receipt_number) &&
                order.equals(that.order) &&
                paymentTotal.equals(that.paymentTotal) &&
                pharmacy.equals(that.pharmacy) &&
                user.equals(that.user) &&
                items.equals(that.items) &&
                typeOfPayment.equals(that.typeOfPayment) &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receipt_number, order, itemQuantity, paymentTotal, pharmacy, user, items, typeOfPayment, date);
    }
}
