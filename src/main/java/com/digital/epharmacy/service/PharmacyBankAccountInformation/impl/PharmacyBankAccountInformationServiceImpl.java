package com.digital.epharmacy.service.PharmacyBankAccountInformation.impl;


import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.repository.PharmacyBankAccountInformation.PharmacyBankAccountInformationRepository;
import com.digital.epharmacy.service.PharmacyBankAccountInformation.PharmacyBankAccountInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccount Information Service implementation gives access to repository
 *       in order to call operations and business logic
 * Date: 03 September 2020
 */
@Service
public class PharmacyBankAccountInformationServiceImpl implements PharmacyBankAccountInformationService {

    @Autowired
    private PharmacyBankAccountInformationRepository repository;


    @Override
    public Set<PharmacyBankAccountInformation> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public PharmacyBankAccountInformation create(PharmacyBankAccountInformation pharmacyBankAccountInformation) {
        try{
            return this.repository.save(pharmacyBankAccountInformation);
        } catch (Exception e){
            throw new MyCustomExceptionHandler("Pharmacy '" + pharmacyBankAccountInformation.getBankAccountId() + "' already exists");
        }

    }

    @Override
    public PharmacyBankAccountInformation read(String pharmacyBankAccountInformation) {
        return this.repository.findById(pharmacyBankAccountInformation).orElseGet(null);
    }

    @Override
    public PharmacyBankAccountInformation update(PharmacyBankAccountInformation pharmacyBankAccountInformation) {
        return this.repository.save(pharmacyBankAccountInformation);
    }

    @Override
    public boolean delete(String pharmacyBankAccountInformation) {
        this.repository.deleteById(pharmacyBankAccountInformation);
        if (this.repository.existsById(pharmacyBankAccountInformation))
            return false;
        return true;
    }

    @Override
    public PharmacyBankAccountInformation findByAccountNumber(int accountNumber) {
        PharmacyBankAccountInformation bankDetails = repository.findByAccountNumber(accountNumber);

        if (bankDetails == null)
            throw new MyCustomExceptionHandler("Bank account does not exist");

        return bankDetails;
    }
}
