package com.digital.epharmacy.service.Payment.impl;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.repository.Payment.PaymentRepository;
import com.digital.epharmacy.service.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static PaymentService service  = null;
    @Autowired
    private PaymentRepository repository;

    @Override
    public Set<Payment> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Payment update(Payment payment) {

        if(this.repository.existsById(payment.getReferenceNumber())){
            return this.repository.save(payment);
        }

        return null;

    }

    @Override
    public boolean delete(String s) {
         this.repository.deleteById(s);
         if(this.repository.existsById(s))  return false;
         else return true;
    }
}
