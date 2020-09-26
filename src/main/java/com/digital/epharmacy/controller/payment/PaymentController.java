package com.digital.epharmacy.controller.payment;
//Matthew Pearce - Payment Controller

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import com.digital.epharmacy.service.Payment.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        Payment newPayment = PaymentFactory.makePayment(payment.getUserID(), payment.getOrderNumber(), payment.getPharmacyID(), payment.getTypeOfPayment(), payment.getPaymentTotal());
        return paymentService.create(newPayment);
    }

    @GetMapping("/read/{userId}")
    public Payment read(@PathVariable String userId){
        return paymentService.read(userId);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment){
        return paymentService.update(payment);
    }

    @GetMapping("/all")
    public Set<Payment>getAll(){
        return paymentService.getAll();
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable String userId){
        return paymentService.delete(userId);
    }
}
