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
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid Service implementation test
 * Date: 02 September 2020
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicalAidServiceImplTest {

    private static MedicalAidService service = MedicalAidServiceImpl.getService();
    private static MedicalAid medicalAid = MedicalAidFactory.
            createMedicalAid(
                    4005785,
                    "BONITAS",
                    "High Benefits"
            );


    @Order(1)
    @Test
    public void a_create() {
        MedicalAid created = service.create(medicalAid);
        Assert.assertEquals(medicalAid.getUserMedicalAidNumber(), created.getUserMedicalAidNumber());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        MedicalAid read = service.read(medicalAid.getUserId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        MedicalAid updated = new MedicalAid.Builder().copy(medicalAid).setUserMedicalAidNumber(78000).build();
        updated = service.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Order(4)
    @Test
    public void d_getAll() {
        Set<MedicalAid> medicalAids = service.getAll();
        assertEquals(1, medicalAids.size());
        System.out.println("Medical Aids: " + medicalAids);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = service.delete(medicalAid.getUserId());
                Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}