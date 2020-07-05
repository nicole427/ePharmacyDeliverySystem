package com.digital.epharmacy.factory;

import com.digital.epharmacy.entity.OrderReceipt;
import org.junit.Test;
import com.digital.epharmacy.entity.ContactInformation;

import java.util.Date;
import static org.junit.Assert.*;
//Author: Keagan Tabisher - Test for creating OrderReceipt 5 July 2020

public class OrderReceiptFactoryTest{

    @Test
    public void CreateOrderReceipt(){
        Date testDate = new Date();
        OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(5,6,3,10,10.55,"Disprin",
                "Cash",testDate);
        assertEquals(5, orderReceipt.getOrderNumber());
        assertEquals(6, orderReceipt.getPharmacyId());
        assertEquals(3, orderReceipt.getUserID());
        assertEquals(10, orderReceipt.getItemQuantity());
        assertEquals(10.55, orderReceipt.getPaymentTotal(), 0);
        assertEquals("Disprin", orderReceipt.getItemName());
        assertEquals("Cash", orderReceipt.getTypeOfPayment());
        assertEquals(testDate, orderReceipt.retreiveDate());
    }
}