/*
 * Author: Ayabulela Mahlathini
 * Desc: Factory for Payment entity
 * Date: 05/07/2020
 * */

package com.digital.epharmacy.factory.Payment;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.util.GenericHelper;

public class PaymentFactory {
    //IDs still need to be retrieved from the UserProfile, Order and Pharmacy classes

    public static Payment makePayment(String userID, String orderNumber, String pharmacyID, String typeOfPayment, double paymentTotal) {

        //payment reference generated using the helper utility, with PAYMENT prefix
        String referenceNumber = "PAYMENT-" + GenericHelper.generateId();

        //payment status, notification and date from the helper utility
        String paymentStatus = GenericHelper.handlePaymentServices(typeOfPayment, paymentTotal);
        String paymentNotification = GenericHelper.handleNotifications(paymentStatus);
        String date = GenericHelper.paymentDate();

        Payment payment = new Payment.Builder()
                .setTypeOfPayment(typeOfPayment)
                .setPaymentTotal(paymentTotal)
                .setOrderNumber(orderNumber)
                .setPharmacyID(pharmacyID)
                .setUserID(userID)
                .setDate(date)
                .setReferenceNumber(referenceNumber)
                .setPaymentStatus(paymentStatus)
                .setPaymentNotification(paymentNotification)
                .build();

        return payment;
    }

}
