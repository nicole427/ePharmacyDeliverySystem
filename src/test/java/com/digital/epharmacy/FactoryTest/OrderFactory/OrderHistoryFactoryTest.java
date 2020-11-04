package com.digital.epharmacy.FactoryTest.OrderFactory;

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.Order.OrderHistoryFactory;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderHistoryFactoryTest {

    UserProfile user = UserProfileFactory
            .createUserProfile("Ayabulela","Mahlathini", "male");


    @Test
    public void createOrderHistory() {

        OrderHistory orderHistory = new OrderHistoryFactory().createOrderHistory(user, 30, new BigDecimal(1500));
        assertEquals(user.getUserId(), orderHistory.getUser().getUserId());
        assertEquals(1500.00, orderHistory.getTotalOrderValue().doubleValue(), 0);
        assertEquals(30, orderHistory.getTotalNumberOfOrders());
    }
}
