package com.digital.epharmacy.repository.MedicalAid.impl;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.repository.MedicalAid.MedicalAidRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid repository implementation
 * Date: 29 August 2020
 */
@Repository
public class MedicalAidRepositoryImpl implements MedicalAidRepository {
    private static MedicalAidRepository repository = null;
    private Set<MedicalAid> medicalAidDB;

    // Constructor
    public MedicalAidRepositoryImpl()
    {
        this.medicalAidDB = new HashSet<>();
    }

    public static MedicalAidRepository getRepository(){
        if(repository == null) repository = new MedicalAidRepositoryImpl();
        return repository;
    }

    @Override
    public MedicalAid create(MedicalAid medicalAid) {
        this.medicalAidDB.add(medicalAid);
        return medicalAid;
    }

    @Override
    public MedicalAid read(String userID) {
        MedicalAid userProfile = null;
        for (MedicalAid u: this.medicalAidDB)
            if(u.getUserId().equalsIgnoreCase(userID)){
                userProfile = u;
            } else if(u.getMedicalAidName().equalsIgnoreCase(userID)){
                userProfile = u;
            }

        return userProfile;
    }

    @Override
    public MedicalAid update(MedicalAid medicalAid) {
        MedicalAid oldMedicalAid = read(medicalAid.getUserId());
        if(oldMedicalAid != null){
            this.medicalAidDB.remove(oldMedicalAid);
            this.medicalAidDB.add(medicalAid);
        }
        return medicalAid;
    }

    @Override
    public boolean delete(String userID) {
        MedicalAid medicalAid =read(userID);
        if (userID != null)
        {
            this.medicalAidDB.remove(medicalAid);
            return true;
        }
        return false;
    }

    @Override
    public Set<MedicalAid> getAll() {
        return this.medicalAidDB;
    }
}
