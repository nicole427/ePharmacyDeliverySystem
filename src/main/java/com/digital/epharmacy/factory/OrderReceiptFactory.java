package com.digital.epharmacy.factory;

import com.digital.epharmacy.entity.*;
import java.util.Date;
 /* Author: Keagan Tabisher
         * Desc: Factory class creating an OrderReceipt object
        * Date: 05/07/2020
        * */
public class OrderReceiptFactory {
    // Class to create Order Receipt as a factory
    public static OrderReceipt createOrderReceipt (int orderNumber, int itemQuantity,
                                                   double paymentTotal,String pharmacyId,
                                                   String userID, String itemName,
                                                   String typeOfPayment, Date date)
    {
        OrderReceipt orderReceipt = new OrderReceipt.Builder()
                .setOrderNumber(orderNumber)
                .setPharmacyID(pharmacyId)
                .setUserID(userID)
                .setItemQuantity(itemQuantity)
                .setPaymentTotal(paymentTotal)
                .setItemName(itemName)
                .setTypeOfPayment(typeOfPayment)
                .settDate(date)
                .build();
        return orderReceipt;
    }
}
