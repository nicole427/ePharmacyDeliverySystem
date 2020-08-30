package com.digital.epharmacy.repository.Order;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

/**
 * Author: Keagan Tabisher - 215028597
 * Date: 30/08/2020
 * Description: Interface for getting the order Receipt from user database
 */

public interface OrderReceiptRepository extends Repository<OrderReceipt,String> {
    Set<OrderReceipt> getAll();
}
