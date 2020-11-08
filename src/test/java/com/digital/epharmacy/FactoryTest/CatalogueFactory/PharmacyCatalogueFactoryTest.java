package com.digital.epharmacy.FactoryTest.CatalogueFactory;

import static org.junit.Assert.*;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.factory.Catalogue.PharmacyCatalogueFactory;
import org.junit.Test;

public class PharmacyCatalogueFactoryTest {

    @Test
    public void createPharmacyCatalogue (){
        PharmacyCatalogue pharmacyCatalogue = PharmacyCatalogueFactory.createPharmacyCatalogue(
                "clinical", "Oral");
        assertNotNull("Pharmacy ID cannot be found", pharmacyCatalogue.getCatalogueId());
        assertEquals("Oral", pharmacyCatalogue.getCatalogueDescription());

    }
}