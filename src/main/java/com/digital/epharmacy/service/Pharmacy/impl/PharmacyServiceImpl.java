package com.digital.epharmacy.service.Pharmacy.impl;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.repository.Pharmacy.Impl.PharmacyRepositoryImpl;
import com.digital.epharmacy.repository.Pharmacy.PharmacyRepository;
import com.digital.epharmacy.service.Pharmacy.PharmacyService;

import java.util.Set;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Service implementation gives access to repository
 *       in order to call operations and business logic
 * Date: 03 September 2020
 */
public class PharmacyServiceImpl implements PharmacyService {

    public static PharmacyService service = null;
    private PharmacyRepository repository;

    private PharmacyServiceImpl(){
        this.repository = PharmacyRepositoryImpl.getRepository();
    }

    public static PharmacyService getService(){
        if(service == null) service = new PharmacyServiceImpl();
        return service;
    }

    @Override
    public Set<Pharmacy> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Pharmacy create(Pharmacy pharmacy) {
        return this.repository.create(pharmacy);
    }

    @Override
    public Pharmacy read(String pharmacy) {
        return this.repository.read(pharmacy);
    }

    @Override
    public Pharmacy update(Pharmacy pharmacy) {
        return this.repository.update(pharmacy);
    }

    @Override
    public boolean delete(String pharmacy) {
        return this.repository.delete(pharmacy);
    }
}
