//package com.digital.epharmacy.repository.Order.Impl;
//
//
///** Author: Ayabulela Mahlathini - 218017774
// * Date: 29/08/2020
// * Description: Testing the implementation of the OrderHistory Respository
// */
//
//
//import com.digital.epharmacy.entity.Order.OrderHistory;
//import com.digital.epharmacy.factory.Order.OrderHistoryFactory;
//
//import com.digital.epharmacy.repository.Order.OrderHistoryRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class OrderHistoryRepositoryImplTest {
//
//    private static OrderHistoryRepository repository = OrderHistoryRepositoryImpl.getRepository();
//
//    private static OrderHistory orderHistory = OrderHistoryFactory
//            .createOrderHistory("User's ID", 25,6500.00);
//
//    @Order(1)
//    @Test
//    void a_create() {
//
//        OrderHistory createdOrderHistory = repository.create(orderHistory);
//        Assert.assertEquals(orderHistory.getUserId(), createdOrderHistory.getUserId());
//        System.out.println("Created:" + createdOrderHistory);
//
//    }
//
//    @Order(2)
//    @Test
//    void b_read() {
//
//        OrderHistory readOrderHistory = repository.read(orderHistory.getUserId());
//        assertEquals(25, readOrderHistory.getTotalNumberOfOrders());
//        System.out.println("Read:" + readOrderHistory);
//    }
//
//    @Order(3)
//    @Test
//    void c_update() {
//
//        OrderHistory updatedOrderHistory = new OrderHistory
//                .Builder()
//                .copy(orderHistory)
//                .setTotalNumberOfOrders(150)
//                .build();
//
//        updatedOrderHistory = repository.update(updatedOrderHistory);
//
//        System.out.println("Updated: " + updatedOrderHistory);
//    }
//
//    @Order(4)
//    @Test
//    void d_getAll() {
//
//        Set<OrderHistory> orderHistories = repository.getAll();
//        assertEquals(1, orderHistories.size());
//
//        System.out.println("Get All: " + orderHistories);
//    }
//
//    @Order(5)
//    @Test
//    void e_delete() {
//        String orderHistoryToDel = orderHistory.getUserId();
//        boolean deleted = repository.delete(orderHistoryToDel);
//
//        Assert.assertTrue(deleted);
//
//        if (deleted) {
//            System.out.println("Deleted: " + orderHistoryToDel);
//        }
//    }
//
//
//}