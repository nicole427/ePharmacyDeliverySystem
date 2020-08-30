package com.digital.epharmacy.factory.Order;
//Matthew Pearce - Order Factory Created to create a order 05 July 2020
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.util.GenericHelper;

public class OrderFactory {

    public static Order createOrder(String userID,   double orderTotal, int totalCatalogueItem, String paymentType,String date){

       //int orderNumber = GenericHelper.generateId();

       Order order = new Order.Builder()
                .setUserID(userID)
                //.setOrderNumber(orderNumber)
                .setOrderTotal(orderTotal)
                .setTotalCatalogueItems(totalCatalogueItem)
                .setPaymentType(paymentType)
                .setDate(date)
                .build();
        return order;

    }
}
