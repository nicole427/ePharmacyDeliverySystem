package com.digital.epharmacy.factory;

import static org.junit.Assert.*;

import com.digital.epharmacy.entity.PharmacyCatalogue;
import org.junit.Test;

public class PharmacyCatalogueFactoryTest {

    @Test
    public void createPharmacyCatalogue (){
        PharmacyCatalogue pharmacyCatalogue = PharmacyCatalogueFactory.createPharmacyCatalogue("random",
                "clinical", "Oral");
        assertNotNull("Pharmacy ID cannot be found", pharmacyCatalogue.getPharmacyId());
        assertEquals("Oral", pharmacyCatalogue.getCatalogueDescription());

    }
}