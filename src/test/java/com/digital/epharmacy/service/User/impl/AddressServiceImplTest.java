package com.digital.epharmacy.service.User.impl;

/*
 * Keagan Tabisher 215028597
 * Date: 05/09/2020
 * Desc: Test case for AddressService Implementation
 * */

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.service.User.AddressService;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceImplTest {

    @Autowired
    private static AddressService service;
    private static Address address = AddressFactory.createAddress("P01", "U01", 99, 50,
            "TygerStreet", "Tygervalley");

    @Test
    void d_getAll() {
        Set<Address> address = service.getAll();
        assertEquals(1, address.size());
        System.out.println("All addresses" + address);
    }

    @Order(1)
    @Test
    void a_create() {
        Address created = service.create(address);
        assertEquals(address.getUserId(), created.getUserId());
        System.out.println("User ID created" + created);
    }

    @Order(2)
    @Test
    void b_read() {
        Address read = service.read(address.getUserId());
        assertEquals(address.getUserId(), read.getUserId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(address).setStreetName("Lemont").setStreetNumber(51).build();
        updated = service.update(updated);
        System.out.println("Updated User" + updated);
    }
    @Order(5)
    @Test
    void e_delete() {
        boolean deleted = service.delete(address.getUserId());
        Assert.assertTrue(deleted);
        System.out.println("User Deleted");
    }
}





