package com.digital.epharmacy.FactoryTest.OrderFactory;
//Matthew Pearce - Test to create new order - 05 July
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.factory.Order.OrderFactory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderFactoryTest {

    @Test
    public void createOrder() {

        Order order = OrderFactory.createOrder(10.00, 10, "EFT");

        String orderNumber = order.getOrderNumber();

        assertEquals("Random", order.getOrderNumber());
        assertEquals(orderNumber ,order.getOrderNumber());
        assertEquals(String.valueOf(10.00),order.getOrderTotal(),0);
        assertEquals(10,order.getTotalCatalogueItems());
        assertEquals("delivered", order.getOrderStatus());
        assertEquals("EFT",order.getPaymentType());
    }


}