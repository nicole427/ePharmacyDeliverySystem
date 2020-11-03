package com.digital.epharmacy.service.Order.Impl;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Testing Implementation for the Order service, getting all orders from the database and handling the business logic
 */

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.repository.Order.OrderRepository;
import com.digital.epharmacy.service.Order.OrderService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceImplTest {

    @Autowired
    private OrderService service;

    private static Order order = OrderFactory
            .createOrder(225.99, 2, "yoco");
    private static Order order2 = OrderFactory
            .createOrder(199.99, 5, "paypal");
    private static Order order3 = OrderFactory
            .createOrder(558.99, 15, "COD");


    @org.junit.jupiter.api.Order(1)
    @Test
    void a_create() {
        Order createdOrder = service.create(order);

        Assert.assertEquals(order.getOrderNumber(), createdOrder.getOrderNumber());
        System.out.println("Created:" + createdOrder);
    }

    @org.junit.jupiter.api.Order(2)
    @Test
    void b_read() {
        Order readOrder = service.read(order.getOrderNumber());
        assertEquals(order.getOrderNumber(), readOrder.getOrderNumber());
        System.out.println("Read:" + readOrder);
    }

    @org.junit.jupiter.api.Order(3)
    @Test
    void c_update() {
        Order updatedOrder = new Order
                .Builder()
                .copy(order)
                .setPaymentType("paypal")
                .build();

        service.update(updatedOrder);
        assertNotEquals(order.getPaymentType(), updatedOrder.getPaymentType());
        System.out.println("Updated: " + updatedOrder);
    }

    @org.junit.jupiter.api.Order(4)
    @Test
    void d_getAll() {

        Set<Order> orders = service.getAll();
        assertEquals(1, orders.size());

        System.out.println("Get All: " + orders);
    }

    @org.junit.jupiter.api.Order(5)
    @Test
    void e_getAllCompletedOrders() {
        service.create(order);
        service.create(order2);
        service.create(order3);

        Order updatedOrder = new Order
                .Builder()
                .copy(order)
                .setOrderStatus("Completed")
                .build();

        service.update(updatedOrder);

        Set<Order> completedOrders = service.getAllCompletedOrders();
        assertEquals(1, completedOrders.size());

        System.out.println("Get All Completed Orders: " + completedOrders);
    }

    @org.junit.jupiter.api.Order(6)
    @Test
    void f_getAllByUser() {
        service.create(order);
        service.create(order2);
        service.create(order3);

        Set<Order> ordersByUser = service.getAllOrdersByUser("user-id");
        assertEquals(2, ordersByUser.size());

        System.out.println("Get All By User's ID: " + ordersByUser);
    }

    @org.junit.jupiter.api.Order(7)
    @Test
    void g_delete() {
        String orderToDel = order3.getOrderNumber();
        boolean deleted = service.delete(orderToDel);

        Assert.assertTrue(deleted);

        if (deleted) {
            System.out.println("Deleted: " + orderToDel);
        }
    }

}