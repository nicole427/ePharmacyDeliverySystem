package com.digital.epharmacy.factory.Catalogue;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.util.GenericHelper;

public class PharmacyCatalogueFactory {

    public static PharmacyCatalogue createPharmacyCatalogue (String catalogueName, String catalogueDescription)
    {
        String catalogueId = GenericHelper.generateId();
        PharmacyCatalogue pharmacyCatalogue = new PharmacyCatalogue.Builder()

                .setCatalogueId(catalogueId)
                .setCatalogueName(catalogueName)
                .setCatalogueDescription(catalogueDescription)
                .build();
        return pharmacyCatalogue;

    }
}
