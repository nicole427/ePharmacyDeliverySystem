package com.digital.epharmacy.service.Order.Impl;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Testing Implementation for the Order service, getting all orders from the database and handling the business logic
 */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.service.CatalogueItem.CatalogueItemService;
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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceImplTest {

    @Autowired
    private OrderService service;
    @Autowired
    private static CatalogueItemService itemService;

    //as per business rules, we need items to place orders
    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
            "oral health", 36, 200);
    private static CatalogueItem catalogueItem2 = CatalogueItemFactory.createCatalogueItem(37, "Mayogel",
            "oral health", 5, 300);

    private static CatalogueItem item1 = itemService.create(catalogueItem);
    private static CatalogueItem item2 = itemService.create(catalogueItem2);

    private  static List<CatalogueItem> items = Stream.of(item1, item2).collect(Collectors.toList());

    private static Order order = OrderFactory
            .createOrder("user-id", items,"yoco");
    private static Order order2 = OrderFactory
            .createOrder("user-id-2", items, "paypal");
    private static Order order3 = OrderFactory
            .createOrder("user-id",  items,"COD");


    @org.junit.jupiter.api.Order(1)
    @Test
    void a_create() {

        System.out.println(order);
        Order createdOrder = service.create(order);
        System.out.println(createdOrder);
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

        Set<Order> ordersByUser = service.getAllOrdersByUser("user-id");
        assertEquals(1, ordersByUser.size());

        System.out.println("Get All By User's ID: " + ordersByUser);
    }

    @org.junit.jupiter.api.Order(7)
    @Test
    void g_delete() {
        String orderToDel = order.getOrderNumber();
        boolean deleted = service.delete(orderToDel);

        Assert.assertTrue(deleted);

        if (deleted) {
            System.out.println("Deleted: " + orderToDel);
        }
    }

}