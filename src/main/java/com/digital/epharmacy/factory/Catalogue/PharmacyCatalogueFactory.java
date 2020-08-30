package com.digital.epharmacy.factory.Catalogue;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.util.GenericHelper;

public class PharmacyCatalogueFactory {

    public static PharmacyCatalogue createPharmacyCatalogue (String pharmacyID, String catalogueName,
                                                                    String catalogueDescription)
    {
        pharmacyID = GenericHelper.generateId();
        PharmacyCatalogue pharmacyCatalogue = new PharmacyCatalogue.Builder()

                .setPharmacyId(pharmacyID)
                .setCatalogueName(catalogueName)
                .setCatalogueDescription(catalogueDescription)
                .build();
        return pharmacyCatalogue;

    }
}
