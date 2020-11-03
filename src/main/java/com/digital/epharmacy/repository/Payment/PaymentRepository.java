package com.digital.epharmacy.repository.Payment;

import com.digital.epharmacy.entity.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
