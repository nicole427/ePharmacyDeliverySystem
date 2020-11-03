package com.digital.epharmacy.repository.Order;

import com.digital.epharmacy.entity.Order.OrderReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderReceiptRepository extends JpaRepository<OrderReceipt, String> {

}
