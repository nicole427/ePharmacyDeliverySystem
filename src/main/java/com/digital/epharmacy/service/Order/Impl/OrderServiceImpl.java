package com.digital.epharmacy.service.Order.Impl;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Implementation for the Order service, getting all orders from the database and handling the business logic
 */

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.repository.Order.Impl.OrderRepositoryImpl;
import com.digital.epharmacy.repository.Order.OrderRepository;
import com.digital.epharmacy.service.Order.OrderService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private static OrderService service = null;
    private OrderRepository repository;

    private OrderServiceImpl(){ this.repository = OrderRepositoryImpl.getRepository();
    }

    public static OrderService getService(){
        if (service == null) service = new OrderServiceImpl();
        return service;
    }

    @Override
    public Set<Order> getAll() {
        return this.repository.getAll();
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
                        .getUserID()
                        .trim()
                        .equalsIgnoreCase(userID))
                .collect(Collectors.toSet());

        return orderHistoryByUser;
    }



    @Override
    public Order create(Order order) {
        return this.repository.create(order);
    }

    @Override
    public Order read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Order update(Order order) {
        return this.repository.update(order);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }
}
