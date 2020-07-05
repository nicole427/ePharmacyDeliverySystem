package com.digital.epharmacy.factory;

import com.digital.epharmacy.entity.Order;
import com.digital.epharmacy.entity.Payment;
import com.digital.epharmacy.entity.Pharmacy;
import com.digital.epharmacy.entity.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentFactory {

    public static Payment makePayment(String userID, String orderNumber, String pharmacyID, String typeOfPayment, double paymentTotal) {


        String referenceNumber = "PAYMENT-" + GenericHelper.generateId();
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
