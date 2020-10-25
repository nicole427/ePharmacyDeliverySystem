/*package com.digital.epharmacy.repository.PharmacyBankAccountInformation.Impl;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import com.digital.epharmacy.repository.PharmacyBankAccountInformation.PharmacyBankAccountInformationRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;*/

/*
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PharmacyBankAccountInformationServiceImplTest {

    private static PharmacyBankAccountInformationRepository repository = PharmacyBankAccountInformationImpl.getRepository();
    private static PharmacyBankAccountInformation bankAccountInformation = PharmacyBankAccountInformationFactory
            .createPharmacyBankAccountInformation(
                    "Standard Bank South Africa",
                    700015721,
                    200145,
                    "001KEL");

    @Order(1)
    @Test
    public void a_create() {
        PharmacyBankAccountInformation created = repository.create(bankAccountInformation);
        Assert.assertEquals(bankAccountInformation.getBankAccountId(), created.getBankAccountId());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        PharmacyBankAccountInformation read = repository.read(bankAccountInformation.getBankName());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        PharmacyBankAccountInformation updated = new PharmacyBankAccountInformation.Builder()
                .copy(bankAccountInformation)
                .setBeneficiaryReference("KEL1983")
                .build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = repository.delete(bankAccountInformation.getBankAccountId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }

    @Order(4)
    @Test
    public void d_getAll() {
        System.out.println("Get All: " + repository.getAll());
    }
}*/
