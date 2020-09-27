package com.digital.epharmacy.service.Order;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Interface for the OrderHistory service, getting all orders from the database
 */

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface OrderHistoryService extends IService<OrderHistory, String> {
    Set<OrderHistory> getAll();
}
