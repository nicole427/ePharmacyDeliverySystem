package com.digital.epharmacy.FactoryTest.OrderFactory;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
//Author: Keagan Tabisher - Test for creating OrderReceipt 5 July 2020

public class OrderReceiptFactoryTest{
    // Test class creating an OrderReceiept object and then using the "assertEquals" to test each variable

    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
            "oral health", 36, 200);
    private static Set<CatalogueItem> items = Stream.of(catalogueItem).collect(Collectors.toSet());

    UserProfile user = UserProfileFactory
            .createUserProfile("Ayabulela","Mahlathini", "male");

    Order order = OrderFactory.createOrder(user, items, "EFT");
    Pharmacy pharmacy = PharmacyFactory.createPharmacy("Lake Side Pharmacy");

    @Test
    // method for testing
    public void CreateOrderReceipt() {
        Date testDate = new Date();
        OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(order, pharmacy);
        assertEquals(order.getOrderNumber(), orderReceipt.getOrder().getOrderNumber());
        assertEquals(pharmacy.getPharmacyId(), orderReceipt.getPharmacy());
        assertEquals(user.getUserId(), orderReceipt.getUser().getUserId());
        assertEquals(1, orderReceipt.getItemQuantity());
        assertEquals(order.getOrderTotal().doubleValue(), orderReceipt.getPaymentTotal().doubleValue(), 0);
        assertEquals("EFT", orderReceipt.getTypeOfPayment());
        assertEquals(testDate, orderReceipt.getDate());
    }
}