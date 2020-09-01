package com.digital.epharmacy.repository.Payment;

import com.digital.epharmacy.entity.Payment.Payment;
import com.digital.epharmacy.repository.Repository;


import java.util.Set;

public interface PaymentRepository extends Repository<Payment, String> {
    Set<Payment> getAll();
}
