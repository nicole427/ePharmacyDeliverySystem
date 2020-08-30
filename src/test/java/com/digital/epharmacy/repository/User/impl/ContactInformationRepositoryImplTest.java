package com.digital.epharmacy.repository.User.impl;

import org.junit.FixMethodOrder;
import org.junit.Test;
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.repository.User.ContactInformationRepository;
import org.junit.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactInformationRepositoryImplTest {

    private static ContactInformationRepository repository = ContactInformationRepositoryImpl.getRepository();
    private static ContactInformation contactInformation = ContactInformationFactory
            .createContactInformation("Matthew", "Dischem", 2, 6);



    @Test
    public void create() {

        ContactInformation created = repository.create(contactInformation);
        Assert.assertEquals(contactInformation.getUserId(), created.getUserId());
        System.out.println("Created:" + created);
    }

    @Test
    public void read() {

        ContactInformation read = repository.read(contactInformation.getUserId());
        System.out.println("Read:" + read);

    }

    @Test
    public void update() {

        ContactInformation updated = new ContactInformation.Builder()
                .copy(contactInformation)
                .setPharmacyId("Clicks")
                .build();

        updated = repository.update(updated);
        System.out.println("Updated:" + updated);
    }

    @Test
    public void delete() {

        boolean deleted = repository.delete(contactInformation.getUserId());
        Assert.assertTrue(deleted);

        if(deleted)
            System.out.println("Deleted");
    }

    @Test
    public void getAll() {

        System.out.println("Get All:" + repository.getAll());
    }
}