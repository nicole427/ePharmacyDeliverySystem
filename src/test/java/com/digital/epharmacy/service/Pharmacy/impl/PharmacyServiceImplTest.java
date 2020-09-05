package com.digital.epharmacy.service.Pharmacy.impl;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.service.Pharmacy.PharmacyService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Service implementation test
 * Date: 03 September 2020
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PharmacyServiceImplTest {

    private static PharmacyService service = PharmacyServiceImpl.getService();
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Life Services Pharmacy");


    @Order(1)
    @Test
    public void a_create() {
        Pharmacy created = service.create((pharmacy));
        Assert.assertEquals(pharmacy.getPharmacyId(), created.getPharmacyId());
        System.out.println("Creatd: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        Pharmacy read = service.read(pharmacy.getPharmacyId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        Pharmacy updated = new Pharmacy.Builder().copy(pharmacy).setPharmacyName("Revenue Pharmacy").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(4)
    @Test
    public void d_getAll() {
        Set<Pharmacy> pharmacies = service.getAll();
        assertEquals(1, pharmacies.size());
        System.out.println("Pharmacies: " + pharmacies);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = service.delete(pharmacy.getPharmacyId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}