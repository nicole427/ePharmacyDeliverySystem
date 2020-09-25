package com.digital.epharmacy.service.Pharmacy.impl;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.repository.Pharmacy.Impl.PharmacyRepositoryImpl;
import com.digital.epharmacy.repository.Pharmacy.PharmacyRepository;
import com.digital.epharmacy.service.Pharmacy.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;

import java.util.Set;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Service implementation gives access to repository
 *       in order to call operations and business logic
 * Date: 03 September 2020
 */
@Service
public class PharmacyServiceImpl implements PharmacyService {

    public static PharmacyService service = null;

    @Autowired
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
        try {
            return this.repository.create(pharmacy);
        } catch (Exception e)
        {
            throw new MyCustomExceptionHandler("Pharmacy '" + pharmacy.getPharmacyName() + "' already exists");
        }

    }

    @Override
    public Pharmacy read(String pharmacy) {

        Pharmacy newPharmacy = repository.read(pharmacy);

        if (newPharmacy == null)
            throw new MyCustomExceptionHandler("Pharmacy name or id does not exist");

        return newPharmacy;
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
