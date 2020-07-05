package com.digital.epharmacy.factory;
//Nicole Hawthorne - OrderHistory Factory - 05 July
import com.digital.epharmacy.entity.OrderHistory;
import com.digital.epharmacy.entity.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

public class OrderHistoryFactory {
// still need to retrieve the userId and pharmacyId from their actual classes

    public static OrderHistory createOrderHistory(String userId, int totalNumberOfOrders, double totalOrderValue){
        OrderHistory orderHistory = new OrderHistory.Builder().setUserId(userId)
                .setTotalNumberOfOrders(totalNumberOfOrders)
                .setTotalOrderValue(totalOrderValue)
                .build();
        return orderHistory;
    }
}
