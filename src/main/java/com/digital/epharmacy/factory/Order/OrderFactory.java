package com.digital.epharmacy.factory.Order;
//Matthew Pearce - Order Factory Created to create a order 05 July 2020
//Ayabulela Mahlathini - Uncommented the code for generating order number and adding code for getting the date
//Author: Ayabulela Mahlathini - altered factory to better with databases
//25/10/2020

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class OrderFactory {

    //changed required parameters to accomodate items being ordered
    public static Order createOrder(UserProfile user, Set<CatalogueItem> items, String paymentType) {

        //generating order number
        String orderNumber = GenericHelper.generateId();

        double orderTotal = 0;

        //calculating total for the whole order
        if (items != null) {
            for (CatalogueItem ci : items) {
                double itemsTotal = ci.getItemPrice() * ci.getItemQuantity();
                orderTotal += itemsTotal;
            }
        }
        //getting the date
        String date = GenericHelper.paymentDate();

        //default for the orderStatus
        String orderStatus = "Processing";

        Order order = new Order.Builder()
                .setUser(user)
                .setOrderNumber(orderNumber)
                .setItems(items)
                .setTotalCatalogueItems(items.size())
                .setOrderTotal(BigDecimal.valueOf(orderTotal))
                .setPaymentType(paymentType)
                .setOrderStatus(orderStatus)
                .setDate(date)
                .build();
        return order;


    }
}
