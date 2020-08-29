package com.digital.epharmacy.FactoryTest.PaymentFactory;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentFactoryTest {

    @Test
    public void makePayment() {


        Payment payment = new PaymentFactory().makePayment("USER-randomly-generate", "ORDER-randomly-generate", "PHARM-randomly-generate","yoco",180);


        String paymentReference = payment.getReferenceNumber();
        String date = payment.getDate();
        String notification = payment.getPaymentNotification();


        assertEquals("USER-randomly-generate", payment.getUserID());
        assertEquals("ORDER-randomly-generate", payment.getOrderNumber());
        assertEquals("PHARM-randomly-generate", payment.getPharmacyID());
        assertEquals("yoco", payment.getTypeOfPayment());
        assertEquals(180, payment.getPaymentTotal(), 0);
        assertEquals("complete",payment.getPaymentStatus());
        assertEquals(date, payment.getDate());
        assertEquals(notification, payment.getPaymentNotification());
        assertEquals(paymentReference, payment.getReferenceNumber());
    }
}