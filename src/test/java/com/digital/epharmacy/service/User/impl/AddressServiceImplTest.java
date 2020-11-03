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
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceImplTest {

    @Autowired
    private AddressService service;
    private static Address address = AddressFactory.createAddress(99, 50,
            "TygerStreet", "Tygervalley");


    @Test
    public void d_getAll() {
        Set<Address> address = service.getAll();
        assertNotEquals(100, address.size());
        System.out.println("All addresses" + address);
    }


    @Test
    public void a_create() {
        Address created = service.create(address);
        assertEquals(address.getAddressId(), created.getAddressId());
        System.out.println("User ID created" + created);
    }


    @Test
    public void b_read() {
        Address read = service.read(address.getAddressId());
        assertEquals(address.getAddressId(), read.getAddressId());
        System.out.println("Read: " + read);
    }


    @Test
    public void c_update() {
        Address updated = new Address.Builder().copy(address).setStreetName("Lemont").setStreetNumber(51).build();
        updated = service.update(updated);
        System.out.println("Updated User" + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(address.getAddressId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("User Deleted");
    }
}





