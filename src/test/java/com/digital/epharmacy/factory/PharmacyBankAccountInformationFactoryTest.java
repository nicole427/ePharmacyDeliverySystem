package com.digital.epharmacy.factory;

import com.digital.epharmacy.entity.PharmacyBankAccountInformation;
import org.junit.Test;

import static org.junit.Assert.*;

public class PharmacyBankAccountInformationFactoryTest {

    @Test
    public void createPharmacyBankAccountInformation() {
        PharmacyBankAccountInformation pharmacyBankAccountInformation = PharmacyBankAccountInformationFactory
                .createPharmacyBankAccountInformation("980123",
                "First National Bank", 794629609, 7612, "Viagra");
        assertNotNull("Pharmacy Bank Account Information Cannot Be Found", pharmacyBankAccountInformation.getPharmacyID());
        assertEquals("First National Bank", pharmacyBankAccountInformation.getBankName());
        assertEquals(794629609, pharmacyBankAccountInformation.getAccountNumber());
        assertEquals(7612, pharmacyBankAccountInformation.getBranchCode());
        assertEquals("Paracetamol", pharmacyBankAccountInformation.getBeneficiaryReference());
    }
}