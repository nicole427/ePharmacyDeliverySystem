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


    @Override
    public Set<OrderReceipt> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public OrderReceipt create(OrderReceipt orderReceipt) {
        return this.repository.save(orderReceipt);
    }

    @Override
    public OrderReceipt read(String receiptNumber) {
        return this.repository.findById(receiptNumber).orElseGet(null);
    }

    @Override
    public OrderReceipt update(OrderReceipt orderReceipt) {
        return this.repository.save(orderReceipt);
    }

    @Override
    public boolean delete(String receiptNumber)
    {
        this.repository.deleteById(receiptNumber);
        if (this.repository.existsById(receiptNumber)) return false;
        else return true;
    }
}

