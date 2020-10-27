package com.digital.epharmacy.service.MedicalAid.impl;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.service.MedicalAid.MedicalAidService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;
/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid Service implementation test
 * Date: 02 September 2020
 *
 * Modified: 26 October 2020
 * Changed Method Names to use JPA implementation.
 * Autowired Service
 * Fixed Test to use Spring Test
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicalAidServiceImplTest {

    @Autowired
    private MedicalAidService service;

    private static MedicalAid medicalAid = MedicalAidFactory.
            createMedicalAid(
                    4005785,
                    "BONITAS",
                    "High Benefits"
            );


    @Test
    public void a_create() {
        MedicalAid created = service.create(medicalAid);
        Assert.assertEquals(medicalAid.getUserMedicalAidNumber(), created.getUserMedicalAidNumber());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        MedicalAid read = service.read(medicalAid.getMedicalAidId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        MedicalAid updated = new MedicalAid.Builder().copy(medicalAid).setUserMedicalAidNumber(78000).build();
        updated = service.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void d_getAll() {
        Set<MedicalAid> medicalAids = service.getAll();
        assertNotEquals(150, medicalAids.size());
        System.out.println("Medical Aids: " + medicalAids);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(medicalAid.getMedicalAidId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}