package com.digital.epharmacy.controller.Order;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 24/09/2020
 * Description: Controller for the Orders, (crud for orders, tracking orders and getting past orders by a user)
 */

import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.factory.Order.OrderFactory;
import com.digital.epharmacy.service.Order.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order){
        Order newOrder = OrderFactory
                .createOrder(order.getOrderTotal(), order.getTotalCatalogueItems(), order.getPaymentType());
        return orderService.create(newOrder);
    }

    @GetMapping("/read/{orderID}")
    public Order read(@PathVariable String orderID){
        return orderService.read(orderID);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{userID}")
    public boolean delete(@PathVariable String userID) {
        return orderService.delete(userID);
    }

    @GetMapping("/all")
    public Set<Order> getAll() {
        return orderService.getAll();
    }

    //get all completed orders with payment successful for the delivery guys
    @GetMapping("/completedOrders")
    public Set<Order> getAllCompletedOrders() {
        return orderService.getAllCompletedOrders();
    }

    //tracking order status
    @GetMapping("/trackStatus/{orderID}")
    public String trackOrderStatus(@PathVariable String orderID) {
        return orderService.trackOrderStatus(orderID);
    }

    //getting all the history by a user
    @GetMapping("/pastOrders/{userID}")
    public Set<Order> getAllOrdersByUser(@PathVariable String userID) {
        return orderService.getAllOrdersByUser(userID);
    }

}
