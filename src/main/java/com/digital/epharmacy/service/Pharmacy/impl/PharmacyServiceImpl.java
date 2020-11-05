package com.digital.epharmacy.service.Pharmacy.impl;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.repository.Pharmacy.PharmacyRepository;
import com.digital.epharmacy.service.Pharmacy.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Service implementation gives access to repository
 *       in order to call operations and business logic
 * Date: 03 September 2020
 *
 * Modified: 25 October 2020
 * Removed Singleton Implementation and autowired JPA Repository
 * Fixed method to use JPA
 */
@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    private PharmacyRepository repository;


    @Override
    public Set<Pharmacy> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Pharmacy findPharmacyByPharmacyName(String pharmacyName) {
        Pharmacy newPharmacy = repository.findPharmacyByPharmacyName(pharmacyName);

        if (newPharmacy == null)
            throw new MyCustomExceptionHandler("Pharmacy name or id does not exist");

        return newPharmacy;
    }

    @Override
    public Pharmacy create(Pharmacy pharmacy) {
        try {
            return this.repository.save(pharmacy);
        } catch (Exception e)
        {
            throw new MyCustomExceptionHandler("Pharmacy '" + pharmacy.getPharmacyName() + "' already exists");
        }

    }

    @Override
    public Pharmacy read(String pharmacy) {

        Pharmacy newPharmacy = repository.findById(pharmacy).orElseGet(null);

        if (newPharmacy == null)
            throw new MyCustomExceptionHandler("Pharmacy name or id does not exist");

        return newPharmacy;
    }

    @Override
    public Pharmacy update(Pharmacy pharmacy) {
        if(this.repository.existsById(pharmacy.getPharmacyId())) {
            return this.repository.save(pharmacy);
        }
        else {
            throw new MyCustomExceptionHandler("Pharmacy does not exist.");
        }
    }

    @Override
    public boolean delete(String pharmacy) {
        this.repository.deleteById(pharmacy);
        if (this.repository.existsById(pharmacy)){
            throw new MyCustomExceptionHandler("Entry not deleted");
        }
        else {
            return true;
        }
    }


}
