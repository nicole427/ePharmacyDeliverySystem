package com.digital.epharmacy.factory.Order;
//Matthew Pearce - Order Factory Created to create a order 05 July 2020
//Ayabulela Mahlathini - Uncommented the code for generating order number and adding code for getting the date
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.util.GenericHelper;

public class OrderFactory {

    public static Order createOrder(String userID,   double orderTotal, int totalCatalogueItem, String paymentType){

        //generating order number
       String orderNumber = GenericHelper.generateId();

       //getting the date
        String date = GenericHelper.paymentDate();

        //default for the orderStatus
        String orderStatus = "Processing";

       Order order = new Order.Builder()
                .setUserID(userID)
                .setOrderNumber(orderNumber)
                .setOrderTotal(orderTotal)
                .setTotalCatalogueItems(totalCatalogueItem)
                .setPaymentType(paymentType)
                .setOrderStatus(orderStatus)
                .setDate(date)
                .build();
        return order;

    }
}
