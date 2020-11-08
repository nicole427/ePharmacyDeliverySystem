package com.digital.epharmacy.service.Order.Impl;



import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class OrderReceiptServiceImplTest {

    @Autowired
    private static OrderReceiptService service;
    private static Date firstDate = new Date();

    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
            "oral health", 36, 200);
    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());

    private static UserProfile user = UserProfileFactory
            .createUserProfile("Ayabulela","Mahlathini", "male");

    private static com.digital.epharmacy.entity.Order.Order order = OrderFactory.createOrder(user, items, "EFT");
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Lake Side Pharmacy");


    private static OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(order, pharmacy);

    @Order(1)
    @Test
    void a_create() {

        OrderReceipt createdOrderReceipt = service.create(orderReceipt);
        Assert.assertEquals(orderReceipt.getReceipt_number(), createdOrderReceipt.getReceipt_number());
        System.out.println("Created:" + createdOrderReceipt);

    }

    @Order(2)
    @Test
    void b_read() {

        OrderReceipt readOrderReceipt = service.read(orderReceipt.getReceipt_number());
        assertEquals(30, readOrderReceipt.getItemQuantity());
        System.out.println("Read:" + readOrderReceipt);
    }

    @Order(3)
    @org.junit.Test
    public void c_update() {
        OrderReceipt copyRec = new OrderReceipt.Builder().copy(orderReceipt).setItemQuantity(80).build();
        OrderReceipt updated = service.update(copyRec);
        System.out.println("Updated: " + updated);
        assertEquals(80, updated.getItemQuantity());
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
        boolean deleted = service.delete(orderReceipt.getReceipt_number());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}
