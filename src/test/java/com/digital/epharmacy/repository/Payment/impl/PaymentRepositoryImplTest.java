package com.digital.epharmacy.repository.Payment.impl;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import com.digital.epharmacy.repository.Payment.PaymentRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentRepositoryImplTest {

    private static PaymentRepository repository = PaymentRepositoryImpl.getRepository();
    private static Payment payment = PaymentFactory.makePayment("Matt11","600", "Clicks", "EFT", 500);


    @Test
    public void create() {

        Payment created = repository.create(payment);
        Assert.assertEquals(payment.getUserID(), created.getUserID());
        System.out.println("Created:" + created);
    }

    @Test
    public void read() {

      Payment read = repository.read(payment.getUserID());
      System.out.println("Read:" + read);
    }

    @Test
    public void update() {

        Payment updated = new Payment.Builder()
                .copy(payment)
                .setUserID("Matthew")
                .build();

        updated = repository.update(updated);
        System.out.println("Updated:" + updated);
    }

    @Test
    public void delete() {

        boolean deleted = repository.delete(payment.getUserID());
        Assert.assertTrue(deleted);
        if(deleted)
            System.out.println("Deleted");
    }

    @Test
    public void getAll() {

        System.out.println("Get All:" + repository.getAll());
    }
}