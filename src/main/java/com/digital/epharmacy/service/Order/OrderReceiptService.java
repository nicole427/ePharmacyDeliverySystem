package com.digital.epharmacy.service.Order;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface OrderReceiptService extends IService<OrderReceipt, String> {
    Set<OrderReceipt> getAll();
}
