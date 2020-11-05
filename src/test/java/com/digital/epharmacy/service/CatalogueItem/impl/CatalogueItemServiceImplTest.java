package com.digital.epharmacy.service.CatalogueItem.impl;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.service.CatalogueItem.CatalogueItemService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CatalogueItemServiceImplTest {

    @Autowired
    private CatalogueItemService service;
    private static CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(3658, "MyBulen", "Pain Killers", 6, 80.99);

    @Order(4)
    @Test
    void d_getAll() {
        Set<CatalogueItem> catalogueItems = service.getAll();
        assertEquals(1, catalogueItems.size());
        System.out.println("Catalogue Items: " + catalogueItem);
    }

    @Order(1)
    @Test
    void a_create() {
        CatalogueItem createdCatalogItem = service.create(catalogueItem);
        Assert.assertEquals(catalogueItem.getItemNumber(), createdCatalogItem.getItemNumber());
        System.out.println("Created:" + createdCatalogItem);
    }

    @Order(2)
    @Test
    void b_read() {
        CatalogueItem read = service.read(catalogueItem.getItemDescription());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void c_update() {
        CatalogueItem updatedCatItem = new CatalogueItem
                .Builder()
                .copy(catalogueItem)
                .setItemName("Disprin")
                .build();

        service.update(updatedCatItem);
        assertNotEquals(catalogueItem.getItemName(), updatedCatItem.getItemName());
        System.out.println("Updated: " + updatedCatItem);
    }

    @Order(5)
    @Test
    void e_delete() {
        String catalogueDelete = catalogueItem.getItemName();
        boolean deleted = service.delete(catalogueDelete);

        Assert.assertTrue(deleted);

        if (deleted) {
            System.out.println("Deleted: " + catalogueDelete);
        }
    }
}