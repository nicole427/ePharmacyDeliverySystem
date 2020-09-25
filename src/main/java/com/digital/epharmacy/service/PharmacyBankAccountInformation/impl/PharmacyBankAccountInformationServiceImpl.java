package com.digital.epharmacy.service.PharmacyBankAccountInformation.impl;


import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.repository.PharmacyBankAccountInformation.PharmacyBankAccountInformationRepository;
import com.digital.epharmacy.repository.PharmacyBankAccountInformation.Impl.PharmacyBankAccountInformationImpl;
import com.digital.epharmacy.service.Pharmacy.PharmacyService;
import com.digital.epharmacy.service.PharmacyBankAccountInformation.PharmacyBankAccountInformationService;
import org.springframework.stereotype.Service;

import java.util.Set;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccount Information Service implementation gives access to repository
 *       in order to call operations and business logic
 * Date: 03 September 2020
 */
@Service
public class PharmacyBankAccountInformationServiceImpl implements PharmacyBankAccountInformationService {

    public static PharmacyBankAccountInformationService service = null;
    private PharmacyBankAccountInformationRepository repository;

    private PharmacyBankAccountInformationServiceImpl(){
        this.repository = PharmacyBankAccountInformationImpl.getRepository();
    }

    public static PharmacyBankAccountInformationService getService(){
        if (service == null) service = new PharmacyBankAccountInformationServiceImpl();
        return service;
    }


    @Override
    public Set<PharmacyBankAccountInformation> getAll() {
        return this.repository.getAll();
    }

    @Override
    public PharmacyBankAccountInformation create(PharmacyBankAccountInformation pharmacyBankAccountInformation) {
        try{
            return this.repository.create(pharmacyBankAccountInformation);
        } catch (Exception e){
            throw new MyCustomExceptionHandler("Pharmacy '" + pharmacyBankAccountInformation.getPharmacyID() + "' already exists");
        }

    }

    @Override
    public PharmacyBankAccountInformation read(String pharmacyBankAccountInformation) {
        return this.repository.read(pharmacyBankAccountInformation);
    }

    @Override
    public PharmacyBankAccountInformation update(PharmacyBankAccountInformation pharmacyBankAccountInformation) {
        return this.repository.update(pharmacyBankAccountInformation);
    }

    @Override
    public boolean delete(String pharmacyBankAccountInformation) {
        return this.repository.delete(pharmacyBankAccountInformation);
    }
}
