package com.digital.epharmacy.repository.MedicalAid.impl;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.repository.MedicalAid.MedicalAidRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicalAidRepositoryImplTest {

    private static MedicalAidRepository repository = MedicalAidRepositoryImpl.getRepository();
    private  static MedicalAid medicalAid = MedicalAidFactory.createMedicalAid(19832804,"Health Med", "High Benefits");

    @Order(1)
    @Test
    public void a_create() {
        MedicalAid created = repository.create(medicalAid);
        Assert.assertEquals(medicalAid.getUserMedicalAidNumber(), created.getUserMedicalAidNumber());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        MedicalAid read = repository.read(medicalAid.getUserId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        MedicalAid updated = new MedicalAid.Builder().copy(medicalAid).setMedicalAidScheme("Standard Benefits").build();
        updated = repository.update(updated);
        System.out.println("Update: " + updated);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = repository.delete(medicalAid.getUserId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }

    @Order(4)
    @Test
    public void d_getAll() {
        System.out.println("Get All:" + repository.getAll());
    }
}