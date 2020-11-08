package com.digital.epharmacy.factory.Order;

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

import java.util.Date;
 /* Author: Keagan Tabisher
         * Desc: Factory class creating an OrderReceipt object
        * Date: 05/07/2020
        * */
public class OrderReceiptFactory {
    // Class to create Order Receipt as a factory
    public static OrderReceipt createOrderReceipt (Order order, Pharmacy pharmacy)
    {

       String date = GenericHelper.paymentDate();

        OrderReceipt orderReceipt = new OrderReceipt.Builder()
                .setReceipt_number(order.getOrderNumber())
                .setOrder(order)
                .setPharmacy(pharmacy)
                .setUser(order.getUser())
                .setItemQuantity(order.getTotalCatalogueItems())
                .setPaymentTotal(order.getOrderTotal())
                .setItems(order.getItems())
                .setTypeOfPayment(order.getPaymentType())
                .setDate(date)
                .build();
        return orderReceipt;
    }
}
