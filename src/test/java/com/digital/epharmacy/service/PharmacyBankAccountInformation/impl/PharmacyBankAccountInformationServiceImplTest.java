package com.digital.epharmacy.service.PharmacyBankAccountInformation.impl;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import com.digital.epharmacy.repository.PharmacyBankAccountInformation.Impl.PharmacyBankAccountInformationImpl;
import com.digital.epharmacy.service.PharmacyBankAccountInformation.PharmacyBankAccountInformationService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation Service implementation test
 * Date: 03 September 2020
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PharmacyBankAccountInformationServiceImplTest {

    private static PharmacyBankAccountInformationService service = PharmacyBankAccountInformationServiceImpl.getService();
    private static PharmacyBankAccountInformation bankAccountInformation = PharmacyBankAccountInformationFactory
            .createPharmacyBankAccountInformation(
                    "Pharm202",
                    "Standard Bank",
                    100875,
                    2005,
                    "MedCare"
            );

    @Order(4)
    @Test
    public void d_getAll() {
        Set<PharmacyBankAccountInformation> bankAccountInformationSet = service.getAll();
        assertEquals(1, bankAccountInformationSet.size());
        System.out.println("Bank Accounts: " + bankAccountInformationSet);
    }

    @Order(1)
    @Test
    public void a_create() {
        PharmacyBankAccountInformation created = service.create(bankAccountInformation);
        assertEquals(bankAccountInformation.getPharmacyID(), created.getPharmacyID());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        PharmacyBankAccountInformation read = service.read(bankAccountInformation.getPharmacyID());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        PharmacyBankAccountInformation updated = new PharmacyBankAccountInformation
                .Builder()
                .copy(bankAccountInformation)
                .setBankName("First National bank")
                .setAccountNumber(784102)
                .setBranchCode(14780)
                .build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = service.delete(bankAccountInformation.getPharmacyID());
        assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}