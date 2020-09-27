package com.digital.epharmacy.service.Order.Impl;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.repository.Order.Impl.OrderReceiptRepositoryImpl;
import com.digital.epharmacy.repository.Order.OrderReceiptRepository;
import com.digital.epharmacy.service.Order.OrderReceiptService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderReceiptServiceImpl implements OrderReceiptService {

    private static OrderReceiptService service = null;
    private OrderReceiptRepository repository;

    private OrderReceiptServiceImpl(){ this.repository = OrderReceiptRepositoryImpl.getRepository();}


    public static OrderReceiptService getService(){
        if (service == null) service = new OrderReceiptServiceImpl();
        return service;
    }



    @Override
    public Set<OrderReceipt> getAll() {
        return this.repository.getAll();
    }

    @Override
    public OrderReceipt create(OrderReceipt orderReceipt) {
        return this.repository.create(orderReceipt);
    }

    @Override
    public OrderReceipt read(String orderReceipt) {
        return this.repository.read(orderReceipt);
    }

    @Override
    public OrderReceipt update(OrderReceipt orderReceipt) {
        return this.repository.update(orderReceipt);
    }

    @Override
    public boolean delete(String orderReceipt) {
        return this.repository.delete(orderReceipt);
    }
}

