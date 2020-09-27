package com.digital.epharmacy.service.Payment.impl;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.repository.Payment.PaymentRepository;
import com.digital.epharmacy.repository.Payment.impl.PaymentRepositoryImpl;
import com.digital.epharmacy.service.Payment.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static PaymentService service  = null;
    private PaymentRepository repository;

    private PaymentServiceImpl(){this.repository = PaymentRepositoryImpl.getRepository();}

    public static PaymentService getService(){

        if(service == null)
            service = new PaymentServiceImpl();
        return service;
    }

    @Override
    public Set<Payment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.create(payment);
    }

    @Override
    public Payment read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.update(payment);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
