/*
package com.digital.epharmacy.repository.User.impl;

*/
/*
 * Author: Keagan Tabisher
 * Date: 30/08/2020
 * Desc: UserProfileRepository Test, will test all methods if it does it correctly
 * *//*


import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.repository.User.AddressRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)



public class AddressRepositoryImplTest {
    private static AddressRepository repository = new AddressRepositoryImpl();
    private static Address address = AddressFactory.createAddress("P01",
            "UserId",100,40,"blockStreet",
            "Tyervalley");

    @Order(1)
    @Test
    public void a_create() {
        Address created = repository.create(address);
        assertEquals(address.getUserId(), created.getUserId());
        System.out.println("Create: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        Address read = repository.read(address.getUserId());
        assertEquals(address.getUserId(),read.getUserId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        Address updated = new Address.Builder().copy(address).setAreaCode(05).setAreaName("Bellville")
                .setStreetNumber(44).build();
        updated = repository.update(updated);
        assertEquals(address.getAreaCode(), updated.getAreaCode());
        assertNotEquals(address.getAreaCode(), updated.getAreaCode());
        System.out.println("Update: " + updated );
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted =   repository.delete(address.getUserId());
        Assert.assertTrue(deleted);
        if (deleted){
            System.out.println("Entry deleted");
        }
    }

    @Order(4)
    @Test
    public void d_getAll() {
        Set<Address> address = repository.getAll();
        assertEquals(1, address.size());
        System.out.println(repository.getAll());
    }
}

*/
