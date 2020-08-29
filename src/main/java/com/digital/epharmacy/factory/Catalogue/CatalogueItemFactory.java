package com.digital.epharmacy.factory.Catalogue;
/*
Nelson Mpyana
Desc: Adding catalogue items (catalogue items class)
Date: 05/07/2020
 */

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;

public class CatalogueItemFactory {

    public static CatalogueItem createCatalogueItem (int itemNumber, String itemName, String itemDescription,
                                                     int itemQuantity, double itemPrice ) {


        CatalogueItem catItem = new CatalogueItem.Builder()
                .setItemNumber(itemNumber)
                .setItemName(itemName)
                .setDescription(itemDescription)
                .setItemQuantity(itemQuantity)
                .setPrice(itemPrice)
                .build();

        return catItem;

    }

}
