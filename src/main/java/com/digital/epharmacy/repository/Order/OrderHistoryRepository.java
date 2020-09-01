package com.digital.epharmacy.repository.Order;


import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

/**
 * Author: Ayabulela Mahlathini - 218017774
 * Date: 29/08/2020
 * Description: Interface for getting all the history for orders by a user from the database
 */

public interface OrderHistoryRepository extends Repository<OrderHistory, String> {
    Set<OrderHistory> getAll();
}




