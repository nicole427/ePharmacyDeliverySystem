//package com.digital.epharmacy.repository.Order.Impl;
//
//
///** Author: Ayabulela Mahlathini - 218017774
// * Date: 29/08/2020
// * Description: Testing the implementation of the Order Respository
// */
//
//import com.digital.epharmacy.entity.Order.Order;
//import com.digital.epharmacy.factory.Order.OrderFactory;
//
//import com.digital.epharmacy.repository.Order.OrderRepository;
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class OrderRepositoryImplTest {
//
//    private static OrderRepository repository = OrderRepositoryImpl.getRepository();
//
//    private static Order order = OrderFactory
//            .createOrder("user's id", 105.99, 2, "yoco");
//
//    @org.junit.jupiter.api.Order(1)
//    @Test
//    void a_create() {
//
//        Order createdOrder = repository.create(order);
//        Assert.assertEquals(order.getOrderNumber(), createdOrder.getOrderNumber());
//        System.out.println("Created:" + createdOrder);
//
//    }
//
//    @org.junit.jupiter.api.Order(2)
//    @Test
//    void b_read() {
//
//        Order readOrder = repository.read(order.getOrderNumber());
//        assertEquals(order.getOrderNumber(), readOrder.getOrderNumber());
//        System.out.println("Read:" + readOrder);
//    }
//
//    @org.junit.jupiter.api.Order(3)
//    @Test
//    void c_update() {
//
//        Order updatedOrder = new Order
//                .Builder()
//                .copy(order)
//                .setPaymentType("paypal")
//                .build();
//
//        repository.update(updatedOrder);
//        assertNotEquals(order.getPaymentType(), updatedOrder.getPaymentType());
//        System.out.println("Updated: " + updatedOrder);
//    }
//
//    @org.junit.jupiter.api.Order(4)
//    @Test
//    void d_getAll() {
//
//        Set<Order> orders = repository.getAll();
//        assertEquals(1, orders.size());
//
//        System.out.println("Get All: " + orders);
//    }
//
//    @org.junit.jupiter.api.Order(5)
//    @Test
//    void e_delete() {
//        String orderToDel = order.getOrderNumber();
//        boolean deleted = repository.delete(orderToDel);
//
//        Assert.assertTrue(deleted);
//
//        if (deleted) {
//            System.out.println("Deleted: " + orderToDel);
//        }
//    }
//
//
//}