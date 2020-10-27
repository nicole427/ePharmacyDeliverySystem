package com.digital.epharmacy.service.Order.Impl;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Implementation for the OrderHistory service, getting all orders from the database and handling the business logic
 *
 * Date: 25/10/2020
 * Altered Service to use JpaRepository methods for creating, reading, updating and deleting
 */

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.repository.Order.OrderHistoryRepository;
import com.digital.epharmacy.service.Order.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    private static OrderHistoryService service = null;
    @Autowired
    private OrderHistoryRepository repository;

    @Override
    public Set<OrderHistory> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public OrderHistory create(OrderHistory orderHistory) {
        return this.repository.save(orderHistory);
    }

    @Override
    public OrderHistory read(String id) {
        if (this.repository.existsById(id)) {
            return this.repository.findById(id).orElseGet(null);
        }
        return null;
    }

    @Override
    public OrderHistory update(OrderHistory orderHistory) {
        return this.repository.save(orderHistory);
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
