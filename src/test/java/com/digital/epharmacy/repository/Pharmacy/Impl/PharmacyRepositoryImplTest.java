/*package com.digital.epharmacy.repository.Pharmacy.Impl;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.repository.Pharmacy.PharmacyRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;*/

/*

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PharmacyRepositoryImplTest {

    private static PharmacyRepository repository = PharmacyRepositoryImpl.getRepository();
    private static Pharmacy pharmacy = PharmacyFactory.createPharmacy("Herbal Medical Pharmacy");

    @Order(1)
    @Test
    public void a_create() {
        Pharmacy created = repository.create(pharmacy);
        Assert.assertEquals(pharmacy.getPharmacyId(), created.getPharmacyId());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        Pharmacy read = repository.read(pharmacy.getPharmacyId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        Pharmacy updated = new Pharmacy.Builder().copy(pharmacy).setPharmacyName("Cape Town Health and Wellness Pharmacy").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = repository.delete(pharmacy.getPharmacyId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }

    @Order(4)
    @Test
    public void d_getAll() {
        System.out.println("Get All: " + repository.getAll());
    }
}
*/
