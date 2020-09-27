package com.digital.epharmacy.repository.Order.Impl;

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.repository.Order.OrderHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Ayabulela Mahlathini - 218017774
 * Date: 29/08/2020
 * Description: implementing CRUD for OrderHistory
 */

public class OrderHistoryRepositoryImpl implements OrderHistoryRepository {

    private static OrderHistoryRepository repository = null;
    private Set<OrderHistory> orderHistoryDB;

    private OrderHistoryRepositoryImpl(){ this.orderHistoryDB = new HashSet<>();
    }

    public static OrderHistoryRepository getRepository(){
        if (repository == null) repository = new OrderHistoryRepositoryImpl();
        return repository;
    }

    //creating user's order history
    @Override
    public OrderHistory create(OrderHistory orderHistory) {
        this.orderHistoryDB.add(orderHistory);
        return orderHistory;
    }

    //reading user's order history
    @Override
    public OrderHistory read(String userId) {
        OrderHistory orderHistory = this.orderHistoryDB
                .stream()
                .filter(o -> o
                        .getUserId()
                        .trim()
                        .equalsIgnoreCase(userId))
                .findAny()
                .orElse(null);
        return orderHistory;
    }

    //updating user's order history
    @Override
    public OrderHistory update(OrderHistory orderHistory) {
        boolean delOrderHistory = delete(orderHistory.getUserId());

        if (delOrderHistory) {
            this.orderHistoryDB.add(orderHistory);
            return orderHistory;
        }
        return null;
    }

    //deleting user's order history
    @Override
    public boolean delete(String userId) {
        OrderHistory orderHistory = read(userId);

        if (orderHistory != null) {
            this.orderHistoryDB.remove(orderHistory);
            return true;
        }

        return false;
    }

    //retrieving all the users' history of orders
    @Override
    public Set<OrderHistory> getAll() {
        return this.orderHistoryDB;
    }

}
