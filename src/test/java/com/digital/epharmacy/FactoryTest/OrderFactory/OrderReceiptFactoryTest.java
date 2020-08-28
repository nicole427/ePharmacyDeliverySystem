package com.digital.epharmacy.FactoryTest.OrderFactory;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import org.junit.Test;

import java.util.Date;
import static org.junit.Assert.*;
//Author: Keagan Tabisher - Test for creating OrderReceipt 5 July 2020

public class OrderReceiptFactoryTest{
    // Test class creating an OrderReceiept object and then using the "assertEquals" to test each variable
    @Test
    // method for testing
    public void CreateOrderReceipt() {
        Date testDate = new Date();
        OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(5,6,3,"Random","Random","Disprin",
                "Cash",testDate);
        assertEquals(5, orderReceipt.getOrderNumber());
        assertEquals("Random", orderReceipt.getPharmacyId());
        assertEquals("Random", orderReceipt.getUserID());
        assertEquals(10, orderReceipt.getItemQuantity());
        assertEquals(10.55, orderReceipt.getPaymentTotal(), 0);
        assertEquals("Disprin", orderReceipt.getItemName());
        assertEquals("Cash", orderReceipt.getTypeOfPayment());
        assertEquals(testDate, orderReceipt.getDate());
    }
}