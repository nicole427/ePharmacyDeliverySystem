package com.digital.epharmacy.service.Payment.impl;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import com.digital.epharmacy.service.Payment.PaymentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceImplTest {

    @Autowired
    private static PaymentService service;
    private static Payment payment = PaymentFactory.makePayment("Matthew","26589","Dischem","EFT",50.00);

    @Test
    void getAll() {

        Set<Payment> payment = service.getAll();
        assertEquals(0,payment.size());
        System.out.println("Amount of Payments" + payment);
    }

    @Test
    void create() {

        Payment created = service.create(payment);
        assertEquals(payment.getUserID(),created.getUserID());
        System.out.println("New User Created: " + created);
    }

    @Test
    void read() {

        Payment read = service.read(payment.getUserID());
        assertEquals(payment.getUserID(), read.getUserID());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {

        Payment updated = new Payment.Builder().copy(payment).setUserID("Chervon").setOrderNumber("1000").build();
        updated = service.update(updated);
        System.out.println("User updated successfully: " + updated);
    }

    @Test
    void delete() {

        boolean deleted = service.delete(payment.getUserID());
        Assert.assertTrue(deleted);
        System.out.println("User has been deleted successfully.");
    }
}