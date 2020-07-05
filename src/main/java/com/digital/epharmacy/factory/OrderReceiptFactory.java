package com.digital.epharmacy.factory;

import com.digital.epharmacy.entity.*;
import java.util.Date;

public class OrderReceiptFactory {

    public static OrderReceipt createOrderReceipt (int orderNumber, int pharmacyId, int userID,
                                                   int itemQuantity, double paymentTotal,String itemName,
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
