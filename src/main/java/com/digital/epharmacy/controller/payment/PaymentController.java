package com.digital.epharmacy.controller.payment;
//Matthew Pearce - Payment Controller

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.factory.Payment.PaymentFactory;
import com.digital.epharmacy.service.Payment.PaymentService;
import com.digital.epharmacy.service.Payment.impl.PaymentServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<Payment> create(@Valid @RequestBody Payment payment, BindingResult result) {
        ResponseEntity<Payment>  errorMap = (ResponseEntity<Payment>) validationService.MapValidationService(result);

        if(errorMap != null){

            return errorMap;
        }

        Payment newPayment = PaymentFactory
                .makePayment(
                        payment.getUserID(),
                        payment.getOrderNumber(),
                        payment.getPharmacyID(),
                        payment.getTypeOfPayment(),
                        payment.getPaymentTotal()
                );
        paymentService.create(newPayment);

        return new ResponseEntity<Payment>(newPayment, HttpStatus.CREATED);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<Payment> read (@PathVariable String userID){

        Payment newPayment = paymentService.read(userID);
        return new ResponseEntity<Payment>(newPayment, HttpStatus.OK);
    }

    @PostMapping("/update")
    public Payment update(@Valid @RequestBody Payment payment){
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
