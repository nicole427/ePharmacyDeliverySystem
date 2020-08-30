package com.digital.epharmacy.repository.Order.Impl;

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.repository.Order.OrderHistoryRepository;
import com.digital.epharmacy.repository.Order.OrderReceiptRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Keagan Tabisher - 215028597
 * Date: 30/08/2020
 * Description: implementing CRUD for OrderReceipt
 */

public class OrderReceiptRepositoryImpl implements OrderReceiptRepository{

    private static OrderReceiptRepository repository = null;
    private Set<OrderReceipt> orderReceiptDB;

    private OrderReceiptRepositoryImpl(){ this.orderReceiptDB = new HashSet<>();
    }

    public static OrderReceiptRepository getRepository(){
        if (repository == null) repository = new OrderReceiptRepositoryImpl();
        return repository;
    }
    @Override
    public OrderReceipt create(OrderReceipt orderReceipt) {
        this.orderReceiptDB.add(orderReceipt);
        return orderReceipt;
    }

    @Override
    public OrderReceipt read(String userID) {
        OrderReceipt orderReceipt = this.orderReceiptDB
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

        if (delOrderReceipt)
        {
            this.orderReceiptDB.add(orderReceipt);
            return orderReceipt;
        }
        return null;
    }

    @Override
    public boolean delete(String userId) {
        OrderReceipt orderReceipt = read(userId);

        if (orderReceipt != null) {
            this.orderReceiptDB.remove(orderReceipt);
            return true;
        }

        return false;
    }

    @Override
    public Set<OrderReceipt> getAll() {
        return this.orderReceiptDB;
    }
}
