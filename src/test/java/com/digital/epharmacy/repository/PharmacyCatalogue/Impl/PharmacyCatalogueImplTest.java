///*
// * Author: Matsobane Nelson Mpyana
// * Desc: PharmacyCatalogueImpTest
// * Date: 29 August 2020
// */
//
//package com.digital.epharmacy.repository.PharmacyCatalogue.Impl;
//
//import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
//import com.digital.epharmacy.factory.Catalogue.PharmacyCatalogueFactory;
//import  com.digital.epharmacy.repository.PharmacyCatalogue.PharmacyCatalogueRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runners.MethodSorters;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
//public class PharmacyCatalogueImplTest {
//
//    private static PharmacyCatalogueRepository repository = PharmacyCatalogueRepositoryImpl.getRepository();
//    private static PharmacyCatalogue pharmacyCatalogue = PharmacyCatalogueFactory.createPharmacyCatalogue("Random",
//            "Oral", "Oral");
//
//    @Order(1)
//    @Test
//    public void a_create() {
//        PharmacyCatalogue created = repository.create(pharmacyCatalogue);
//        Assert.assertEquals(pharmacyCatalogue.getPharmacyId(), created.getPharmacyId());
//        System.out.println("Created: " + created);
//    }
//
//    @Order(2)
//    @Test
//    public void b_read() {
//        PharmacyCatalogue read = repository.read(pharmacyCatalogue.getPharmacyId());
//        System.out.println("Read: " + read);
//    }
//
//    @Order(3)
//    @Test
//    public void c_update() {
//        PharmacyCatalogue updated = new PharmacyCatalogue.Builder().copy(pharmacyCatalogue).setCatalogueName("Beauty Fair").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Order(5)
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(pharmacyCatalogue.getPharmacyId());
//        Assert.assertTrue(deleted);
//
//        if (deleted)
//            System.out.println("Entry Deleted");
//    }
//
//    @Order(4)
//    @Test
//    public void d_getAll() {
//
//        System.out.println("Get All: " + repository.getAll());
//    }
//}