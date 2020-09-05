package com.digital.epharmacy.service.Payment;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface PaymentService extends IService <Payment, String> {

    Set<Payment>getAll();

}

