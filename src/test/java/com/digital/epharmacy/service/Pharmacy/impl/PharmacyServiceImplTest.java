package com.digital.epharmacy.service.Pharmacy.impl;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.service.Pharmacy.PharmacyService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Service implementation test
 * Date: 03 September 2020
 *
 * Modified: 25 October 2020
 * Changed Method Names to use JPA implementation.
 * Autowired Service
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PharmacyServiceImplTest {

    @Autowired
    private PharmacyService service;

    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Life Services Pharmacy");


    @Test
    public void a_create() {
        Pharmacy created = service.create(pharmacy);
        Assert.assertEquals(pharmacy.getPharmacyId(), created.getPharmacyId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Pharmacy read = service.read(pharmacy.getPharmacyId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Pharmacy updated = new Pharmacy.Builder().copy(pharmacy).setPharmacyName("Revenue Pharmacy").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void d_getAll() {
        Set<Pharmacy> pharmacies = service.getAll();
        assertNotEquals(101, pharmacies.size());
        System.out.println("Pharmacies: " + pharmacies);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(pharmacy.getPharmacyId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}