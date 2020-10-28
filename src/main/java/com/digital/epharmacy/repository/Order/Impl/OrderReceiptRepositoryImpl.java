/*
package com.digital.epharmacy.repository.Order.Impl;


import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.repository.Order.OrderHistoryRepository;
import com.digital.epharmacy.repository.Order.OrderReceiptRepository;

import java.util.Set;
import java.util.HashSet;

public class OrderReceiptRepositoryImpl implements OrderReceiptRepository {

    private static OrderReceiptRepository repository = null;
    private Set<OrderReceipt> orderReceiptsDB;

    private OrderReceiptRepositoryImpl() {
        this.orderReceiptsDB = new HashSet<>();
    }

    public static OrderReceiptRepository getRepository() {
        if (repository == null) repository = new OrderReceiptRepositoryImpl();
        return repository;
    }


    @Override
    public OrderReceipt create(OrderReceipt orderReceipt) {
        this.orderReceiptsDB.add(orderReceipt);
        return orderReceipt;
    }

    @Override
    public OrderReceipt read(String userID) {
        OrderReceipt orderReceipt = this.orderReceiptsDB
                .stream()
                .filter(o -> o
                        .getUserID()
                        .trim()
                        .equalsIgnoreCase(userID))
                .findAny()
                .orElse(null);
        return orderReceipt;
    }

    @Override
    public OrderReceipt update(OrderReceipt orderReceipt) {
        boolean delOrderReceipt = delete(orderReceipt.getUserID());

        if (delOrderReceipt) {
            this.orderReceiptsDB.add(orderReceipt);
            return orderReceipt;
        }
        return null;
    }

    @Override
    public boolean delete(String userID) {
        OrderReceipt orderReceipt = read(userID);

        if (orderReceipt != null) {
            this.orderReceiptsDB.remove(orderReceipt);
            return true;
        }

        return false;
    }

    @Override
    public Set<OrderReceipt> getAll() {
        return this.orderReceiptsDB;
    }




}
*/
