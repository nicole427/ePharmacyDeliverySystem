package com.digital.epharmacy.service.Order;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Interface for the Order service, getting all orders from the database
 */

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface OrderService extends IService<Order, String> {
    Set<Order> getAll();

    Set<Order> getAllCompletedOrders();

    String trackOrderStatus(String orderID);

    Set<Order> getAllOrdersByUser(String userID);


}
