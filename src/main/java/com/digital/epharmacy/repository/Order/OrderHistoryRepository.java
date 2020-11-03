package com.digital.epharmacy.repository.Order;


import com.digital.epharmacy.entity.Order.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Author: Ayabulela Mahlathini - 218017774
 * Date: 29/08/2020
 * Description: Interface for getting all the history for orders by a user from the database
 *
 * Date: 25/08/2020
 * Desc: changed from the depricated Repository to using the JpaRepository
 */
@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, String> { }




