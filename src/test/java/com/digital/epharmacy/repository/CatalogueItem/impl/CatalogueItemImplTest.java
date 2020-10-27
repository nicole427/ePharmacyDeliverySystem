///*
// * Author: Matsobane Nelson Mpyana
// * Desc: CatalogueItemImpl Test
// * Date: 30 August 2020
// */
//package com.digital.epharmacy.repository.CatalogueItem.impl;
//
//import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
//import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
//import com.digital.epharmacy.repository.CatalogueItem.CatalogueItemRepository;
////mport com.digital.epharmacy.repository.CatalogueItem.Impl.CatalogueItemRepositoryImpl;
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
//public class CatalogueItemImplTest {
//    private static CatalogueItemRepository repository = CatalogueItemRepositoryImpl.getRepository();
//    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36,"Mayogel",
//            "Heart burn relief", 36,200 );
//
//    @Order(1)
//    @Test
//    public void a_create() {
//        CatalogueItem created = repository.create(catalogueItem);
//        Assert.assertEquals(catalogueItem.getItemName(), created.getItemName());
//        System.out.println("Created: " + created);
//    }
//
//    @Order(2)
//    @Test
//    public void b_read() throws Exception {
//        CatalogueItem read = repository.read(catalogueItem.getItemName());
//        System.out.println("Read: " + read);
//    }
//
//    @Order(3)
//    @Test
//    public void c_update() {
//        CatalogueItem updated = new CatalogueItem.Builder().copy(catalogueItem).setItemName("Moringa").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//    @Order(5)
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(catalogueItem.getItemName());
//        Assert.assertTrue(deleted);
//
//        if (deleted)
//            System.out.println("Entry Deleted");
//    }
//    @Order(4)
//    @Test
//    public void d_getAll() {
//
//        System.out.println("Get All: " + repository.getAll());
//    }
//
//}
