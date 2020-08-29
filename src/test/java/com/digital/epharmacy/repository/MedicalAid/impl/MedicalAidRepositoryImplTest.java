package com.digital.epharmacy.repository.MedicalAid.impl;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.repository.MedicalAid.MedicalAidRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicalAidRepositoryImplTest {

    private static MedicalAidRepository repository = MedicalAidRepositoryImpl.getRepository();
    private  static MedicalAid medicalAid = MedicalAidFactory.createMedicalAid("KEL1938", 19832804,"Health Med", "High Benefits");

    @Test
    public void a_create() {
        MedicalAid created = repository.create(medicalAid);
        Assert.assertEquals(medicalAid.getUserMedicalAidNumber(), created.getUserMedicalAidNumber());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        MedicalAid read = repository.read(medicalAid.getUserId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        MedicalAid updated = new MedicalAid.Builder().copy(medicalAid).setMedicalAidScheme("Standard Benefits").build();
        updated = repository.update(updated);
        System.out.println("Update: " + updated);
    }

    @Test
    public void d_delete() {
        boolean deleted = repository.delete(medicalAid.getUserId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void getAll() {
    }
}