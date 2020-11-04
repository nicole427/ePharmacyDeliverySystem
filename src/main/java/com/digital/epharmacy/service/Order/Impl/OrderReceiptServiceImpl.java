package com.digital.epharmacy.service.Order.Impl;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.repository.Order.OrderReceiptRepository;
import com.digital.epharmacy.service.Order.OrderReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderReceiptServiceImpl implements OrderReceiptService {

    @Autowired
    private OrderReceiptRepository repository;


    @Override @Transactional
    public Set<OrderReceipt> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override @Transactional
    public OrderReceipt create(OrderReceipt orderReceipt) {
        return this.repository.save(orderReceipt);
    }

    @Override @Transactional
    public OrderReceipt read(String orderReceipt) {
        return this.repository.findById(orderReceipt).orElseGet(null);
    }

    @Override @Transactional
    public OrderReceipt update(OrderReceipt orderReceipt) {
        return this.repository.save(orderReceipt);
    }

    @Override @Transactional
    public boolean delete(String orderReceipt)
    {
        this.repository.deleteById(orderReceipt);
        if (this.repository.existsById(orderReceipt)) return false;
        else return true;
    }
}

