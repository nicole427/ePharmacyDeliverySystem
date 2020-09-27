package com.digital.epharmacy.service.Order.Impl;

/** Author: Ayabulela Mahlathini - 218017774
 * Date: 03/09/2020
 * Description: Implementation for the OrderHistory service, getting all orders from the database and handling the business logic
 */

import com.digital.epharmacy.entity.Order.OrderHistory;
import com.digital.epharmacy.repository.Order.Impl.OrderHistoryRepositoryImpl;
import com.digital.epharmacy.repository.Order.OrderHistoryRepository;
import com.digital.epharmacy.service.Order.OrderHistoryService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    private static OrderHistoryService service = null;
    private OrderHistoryRepository repository;

    private OrderHistoryServiceImpl(){ this.repository = OrderHistoryRepositoryImpl.getRepository();
    }

    public static OrderHistoryService getService(){
        if (service == null) service = new OrderHistoryServiceImpl();
        return service;
    }

    @Override
    public Set<OrderHistory> getAll() {
        return this.repository.getAll();
    }

    @Override
    public OrderHistory create(OrderHistory orderHistory) {
        return this.repository.create(orderHistory);
    }

    @Override
    public OrderHistory read(String id) {
        return this.repository.read(id);
    }

    @Override
    public OrderHistory update(OrderHistory orderHistory) {
        return this.repository.update(orderHistory);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }
}
