package com.digital.epharmacy.service.MedicalAid.impl;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.repository.MedicalAid.MedicalAidRepository;
import com.digital.epharmacy.repository.MedicalAid.impl.MedicalAidRepositoryImpl;
import com.digital.epharmacy.service.MedicalAid.MedicalAidService;
import org.springframework.stereotype.Service;

import java.util.Set;
/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid Service implementation gives access to repository
 *       in order to call operations and business logic
 * Date: 02 September 2020
 */
@Service
public class MedicalAidServiceImpl implements MedicalAidService {

    public static MedicalAidService service = null;
    private MedicalAidRepository repository;

    // Constructor
    private MedicalAidServiceImpl(){
        this.repository = MedicalAidRepositoryImpl.getRepository();
    }

    public static MedicalAidService getService(){
        if (service == null) service = new MedicalAidServiceImpl();
        return service;
    }

    @Override
    public Set<MedicalAid> getAll() {
        return this.repository.getAll();
    }

    @Override
    public MedicalAid create(MedicalAid medicalAid) {
        return this.repository.create(medicalAid);
    }

    @Override
    public MedicalAid read(String medicalAid) {
        return this.repository.read(medicalAid);
    }

    @Override
    public MedicalAid update(MedicalAid medicalAid) {
        return this.repository.update(medicalAid);
    }

    @Override
    public boolean delete(String medicalAid) {
        return this.repository.delete(medicalAid);
    }


}
