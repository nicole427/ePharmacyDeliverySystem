package com.digital.epharmacy.factory.Order;
//Nicole Hawthorne - OrderHistory Factory - 05 July
import com.digital.epharmacy.entity.Order.OrderHistory;

import java.math.BigDecimal;

public class OrderHistoryFactory {
// still need to retrieve the userId and pharmacyId from their actual classes

    public static OrderHistory createOrderHistory(String userId, int totalNumberOfOrders, BigDecimal totalOrderValue){
        OrderHistory orderHistory = new OrderHistory.Builder().setUserId(userId)
                .setTotalNumberOfOrders(totalNumberOfOrders)
                .setTotalOrderValue(totalOrderValue)
                .build();
        return orderHistory;
    }
}
