package com.digital.epharmacy.FactoryTest.OrderFactory;

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.factory.Order.OrderHistoryFactory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderHistoryFactoryTest {

    @Test
    public void createOrderHistory() {

        OrderHistory orderHistory = new OrderHistoryFactory().createOrderHistory("USER-randomly-generate", 30, new BigDecimal(1500));
        assertEquals("USER-randomly-generate", orderHistory.getUserId());
        assertEquals(1500.00, orderHistory.getTotalOrderValue().doubleValue(), 0);
        assertEquals(30, orderHistory.getTotalNumberOfOrders());
    }
}