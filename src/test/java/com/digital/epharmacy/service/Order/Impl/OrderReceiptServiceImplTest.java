package com.digital.epharmacy.service.Order.Impl;



import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.service.Order.OrderReceiptService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class OrderReceiptServiceImplTest {

    @Autowired
    private static OrderReceiptService service;
    private static Date firstDate = new Date();

    private static OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(100,
            30,50.00,"P01","U01","Disprin",
            "Cash",firstDate);

    @Order(1)
    @Test
    void a_create() {

        OrderReceipt createdOrderReceipt = service.create(orderReceipt);
        Assert.assertEquals(orderReceipt.getUserID(), createdOrderReceipt.getUserID());
        System.out.println("Created:" + createdOrderReceipt);

    }

    @Order(2)
    @Test
    void b_read() {

        OrderReceipt readOrderReceipt = service.read(orderReceipt.getUserID());
        assertEquals(30, readOrderReceipt.getItemQuantity());
        System.out.println("Read:" + readOrderReceipt);
    }

    @Order(3)
    @org.junit.Test
    public void c_update() {
        OrderReceipt updated = new OrderReceipt.Builder().copy(orderReceipt).setItemName("bandages").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(4)
    @org.junit.Test
    public void d_getAll() {
        Set<OrderReceipt> orderReceipts = service.getAll();
        Assert.assertEquals(1, orderReceipts.size());
        System.out.println("Order Receipts: " + orderReceipts);
    }

    @Order(5)
    @org.junit.Test
    public void e_delete() {
        boolean deleted = service.delete(orderReceipt.getPharmacyId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}
