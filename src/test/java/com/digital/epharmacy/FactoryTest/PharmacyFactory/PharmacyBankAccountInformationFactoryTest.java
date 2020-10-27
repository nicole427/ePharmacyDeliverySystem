package com.digital.epharmacy.FactoryTest.PharmacyFactory;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PharmacyBankAccountInformationFactoryTest {

    @Test
    public void createPharmacyBankAccountInformation() {
        PharmacyBankAccountInformation pharmacyBankAccountInformation = PharmacyBankAccountInformationFactory
                .createPharmacyBankAccountInformation(
                "First National Bank", 794629609, 7612, "Viagra");
        assertNotNull("Pharmacy Bank Account Information Cannot Be Found", pharmacyBankAccountInformation.getBankAccountId());
        assertEquals("First National Bank", pharmacyBankAccountInformation.getBankName());
        assertEquals(794629609, pharmacyBankAccountInformation.getAccountNumber());
        assertEquals(7612, pharmacyBankAccountInformation.getBranchCode());
        assertEquals("Paracetamol", pharmacyBankAccountInformation.getBeneficiaryReference());
    }
}