package com.digital.epharmacy.repository.Order;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

public interface OrderReceiptRepository extends Repository<OrderReceipt, String> {
    Set<OrderReceipt> getAll();
}
