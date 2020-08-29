package com.digital.epharmacy.FactoryTest.CatalogueFactory;
/*
Nelson Mpyana
Desc: Test Adding catalogue items
Date: 05/07/2020
 */
import static org.junit.Assert.assertEquals;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import org.junit.Test;

public class CatalogueItemFactoryTest {

    @Test
    public void createCatalogueItem() {
        CatalogueItem catalogueItem = CatalogueItemFactory.createCatalogueItem(36, "Mayogel",
                "oral health", 36, 200);
        assertEquals(36, catalogueItem.getItemNumber());
        assertEquals("Mayogel", catalogueItem.getItemName());
        assertEquals("oral health", catalogueItem.getItemDescription());
        assertEquals(36, catalogueItem.getItemQuantity());
        assertEquals(200, catalogueItem.getItemPrice(), 0.1);

    }
}