package com.digital.epharmacy.service.PrescriptionItem.impl;
/*
 * Author: Matsobane Nelson Mpyana
 * Desc: CatalogueItem Serive Test
 * Date: 30 August 2020
 */

import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.factory.Catalogue.PrescriptionItemFactory;
import com.digital.epharmacy.service.PrescriptionItem.PrescriptionItemService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PrescriptionItemServiceImplTest {

    @Autowired
    private static PrescriptionItemService service;
    private static PrescriptionItem prescriptionItem = PrescriptionItemFactory.createPrescriptionItem(
            6332, "Eye Drop", "Dr Smith");

    @Order(5)
    @Test

    public void e_getAll() {
        System.out.println("Get All: " + service.getAll());
    }

    @Order(1)
    @Test
    public void a_create() {
        PrescriptionItem created = service.create((prescriptionItem));
        Assert.assertEquals(prescriptionItem.getPrescriptionNumber(), created.getPrescriptionNumber());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test

    public void b_read() {
        PrescriptionItem read = service.read(prescriptionItem.getPrescribingDoctor());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test

    void c_update() {
        PrescriptionItem updated = new PrescriptionItem.Builder().copy(prescriptionItem).setPrescriptionType("Spectacles").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(4)
    @Test

    void d_delete() {
        boolean deleted = service.delete(prescriptionItem.getPrescriptionType());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");

    }
}