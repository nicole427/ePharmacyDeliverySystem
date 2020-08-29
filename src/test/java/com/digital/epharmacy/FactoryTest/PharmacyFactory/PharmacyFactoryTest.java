package com.digital.epharmacy.FactoryTest.PharmacyFactory;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Factory creation test
 * Date: 05 July 2020
 */
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PharmacyFactoryTest {

    @Test
    public void createPharmacy() {
        Pharmacy pharmacy = PharmacyFactory.createPharmacy("Lake Side Pharmacy");
        assertNotNull("Pharmacy ID cannot be found", pharmacy.getPharmacyId());
        assertEquals("Cape Town Pharmacy", pharmacy.getPharmacyName());
    }
}