//package com.digital.epharmacy.repository.Order.Impl;
//
//import com.digital.epharmacy.entity.Order.Order;
//import com.digital.epharmacy.repository.Order.OrderRepository;
//import org.springframework.stereotype.Repository;
//
///** Author: Ayabulela Mahlathini - 218017774
// * Date: 29/08/2020
// * Description: implementing CRUD for Orders
// */
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class OrderRepositoryImpl implements OrderRepository {
//
//    private static OrderRepository repository = null;
//    private Set<Order> orderDB;
//
//    private OrderRepositoryImpl(){ this.orderDB = new HashSet<>();
//    }
//
//    public static OrderRepository getRepository(){
//        if (repository == null) repository = new OrderRepositoryImpl();
//        return repository;
//    }
//
//    //creating an order
//    @Override
//    public Order create(Order order) {
//        this.orderDB.add(order);
//        return order;
//    }
//
//    //reading an order
//    @Override
//    public Order read(String orderNumber) {
//        Order order = this.orderDB
//                .stream()
//                .filter(o -> o
//                        .getOrderNumber()
//                        .trim()
//                        .equalsIgnoreCase(orderNumber))
//                .findAny()
//                .orElse(null);
//        return order;
//    }
//
//    //updating an order
//    @Override
//    public Order update(Order order) {
//        boolean delOrder = delete(order.getOrderNumber());
//
//        if (delOrder) {
//            this.orderDB.add(order);
//            return order;
//        }
//        return null;
//    }
//
//    //deleting an order
//    @Override
//    public boolean delete(String orderNumber) {
//        Order order = read(orderNumber);
//
//        if (order != null) {
//            this.orderDB.remove(order);
//            return true;
//        }
//
//        return false;
//    }
//
//    //retrieving all orders
//    @Override
//    public Set<Order> getAll() {
//        return this.orderDB;
//    }
//
//}
