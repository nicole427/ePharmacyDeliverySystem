/*
package com.digital.epharmacy.repository.Order.Impl;

*/
/** Author: Keagan Tabisher - 215028597
 * Date: 30/08/2020
 * Description: Testing the implementation of the OrderReceipt Respository
 *//*



import com.digital.epharmacy.entity.Order.OrderReceipt;
import com.digital.epharmacy.factory.Order.OrderReceiptFactory;
import com.digital.epharmacy.repository.Order.OrderReceiptRepository;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderReceiptRepositoryImplTest {

    @Autowired
    static Date date = new Date();
    private static OrderReceiptRepository repository;

    private static OrderReceipt orderReceipt = OrderReceiptFactory.createOrderReceipt(1,20,
            40.00,"P01","UserID","Asprin","Cash",date);


    @Order(1)
    @Test
    void a_create(){

        OrderReceipt createdOrderReceipt = repository.create(orderReceipt);
        Assert.assertEquals(orderReceipt.getUserID(), createdOrderReceipt.getUserID());
        System.out.println("Created: " + createdOrderReceipt);
    }

    @Order(2)
    @Test
    void b_read()
    {
        OrderReceipt readOrderReceipt = repository.read((orderReceipt.getUserID()));
        System.out.println("Read: " + readOrderReceipt);
    }

    @Order(3)
    @Test
    public void c_update()
    {
        OrderReceipt updated = new OrderReceipt.Builder().copy(orderReceipt).setUserID("UserID").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(4)
    @Test
    public void d_getAll() {
        System.out.println("Get All:" + repository.findAll());
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = repository.delete(orderReceipt.getUserID());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }

}
*/
