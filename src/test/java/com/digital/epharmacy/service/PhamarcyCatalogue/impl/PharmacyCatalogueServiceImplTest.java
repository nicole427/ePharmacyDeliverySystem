package com.digital.epharmacy.service.PhamarcyCatalogue.impl;

/*
 * Author: Nelson Mpyana
 * Date: 02/09/2020
 * Desc: PhamacyCatalogue Service Impl Test
 * */

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.factory.Catalogue.PharmacyCatalogueFactory;;
import com.digital.epharmacy.service.PharmacyCatalogue.PharmacyCatalogueService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PharmacyCatalogueServiceImplTest {


    @Autowired
    private PharmacyCatalogueService service;
    private static PharmacyCatalogue pharmacyCatalogue = PharmacyCatalogueFactory.createPharmacyCatalogue
            (" Beauty", "Skin care");
    private static PharmacyCatalogue pharmacyCatalogue2 = PharmacyCatalogueFactory.createPharmacyCatalogue
            ( " Health ", "new");

    @Order(1)
    @Test
    public void a_create() {
        PharmacyCatalogue created = service.create((pharmacyCatalogue));
        Assert.assertEquals(pharmacyCatalogue.getCatalogueId(), created.getCatalogueId());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        PharmacyCatalogue read = service.read(pharmacyCatalogue.getCatalogueId());
        System.out.println("Read: " + read);
    }
    @Order(3)
    @Test
    public void c_update() {
        PharmacyCatalogue updated = new PharmacyCatalogue.Builder().copy(pharmacyCatalogue).setCatalogueName("Mascarra").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(4)
    @Test
    public void d_getAll() {
        Set<PharmacyCatalogue> pharmacyCatalogues = service.getAll();
        Assert.assertEquals(1,
                pharmacyCatalogues.size());
        System.out.println("All Pharmacy Catalogues: " + pharmacyCatalogues);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = service.delete(pharmacyCatalogue.getCatalogueId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }


}
