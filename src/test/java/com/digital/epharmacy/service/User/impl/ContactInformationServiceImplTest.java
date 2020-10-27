package com.digital.epharmacy.service.User.impl;

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.service.User.ContactInformationService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ContactInformationServiceImplTest {

    @Autowired
    private static ContactInformationService service;
    private static ContactInformation contactInformation = ContactInformationFactory.createContactInformation("Matthew","DisChem",98,89);

    @Test
    void getAll() {

        Set<ContactInformation> contactInformation = service.getAll();
        assertEquals(0,contactInformation.size());
        System.out.println("Contact Information:" + contactInformation);
    }



    @Test
    void create() {

        ContactInformation created = service.create(contactInformation);
        assertEquals(contactInformation.getUserId(), created.getUserId());
        System.out.println("Contact Information Created For:" + created);
    }

    @Test
    void read() {

        ContactInformation read = service.read(contactInformation.getUserId());
        assertEquals(contactInformation.getUserId(), read.getUserId());
        System.out.println("Read:" + read);

    }

    @Test
    void update() {

        ContactInformation updated = new ContactInformation.Builder().copy(contactInformation).setUserId("Chervon").setPharmacyId("Clicks").build();
        updated = service.update(updated);
        System.out.println("Updated User:" + updated);
    }

    @Test
    void delete() {

        boolean deleted = service.delete(contactInformation.getUserId());
        Assert.assertTrue(deleted);
        System.out.println("User has been deleted successfully");

    }
}