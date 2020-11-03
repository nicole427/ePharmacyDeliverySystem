package com.digital.epharmacy.service.Order.Impl;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Implementation for the Order service, getting all orders from the database and handling the business logic
 *
 * Date: 25/08/2020
 * Desc: Altered Service to use JpaRepository methods for creating, reading, updating and deleting
 */

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.repository.Order.OrderRepository;
import com.digital.epharmacy.service.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Set<Order> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    //get all completed orders with payment successful for the delivery guys
    @Override
    public Set<Order> getAllCompletedOrders() {
        Set<Order> orders = getAll();
        Set<Order> completedOrders;

        completedOrders = orders.stream()
                .filter(o -> o
                        .getOrderStatus()
                        .trim()
                        .equalsIgnoreCase("Completed"))
                .collect(Collectors.toSet());

        return completedOrders;
    }

    //tracking order status
    @Override
    public String trackOrderStatus(String orderID) {
        return this.read(orderID).getOrderStatus();
    }

    //getting all the history by a user
    @Override
    public Set<Order> getAllOrdersByUser(String userID) {
        Set<Order> orders = getAll();
        Set<Order> orderHistoryByUser;

        orderHistoryByUser = orders.stream()
                .filter(o -> o
                        .getOrderNumber()
                        .trim()
                        .equalsIgnoreCase(userID))
                .collect(Collectors.toSet());

        return orderHistoryByUser;
    }



    @Override
    public Order create(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order read(String id) {
        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public Order update(Order order) {
        if (this.repository.existsById(order.getOrderNumber())) {
            return this.repository.save(order);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        if (this.repository.existsById(id)){
            return false;
        } else {
            return true;
        }
    }
}
