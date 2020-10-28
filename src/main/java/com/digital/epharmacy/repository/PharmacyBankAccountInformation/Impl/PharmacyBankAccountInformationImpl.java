/*package com.digital.epharmacy.repository.PharmacyBankAccountInformation.Impl;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.repository.PharmacyBankAccountInformation.PharmacyBankAccountInformationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;*/
/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation implementation
 * Date: 29 August 2020
 *
 * 26 October 2020
 * Extends JPA Repository
 * Deprecated Class
 */
/*
@Repository
public class PharmacyBankAccountInformationImpl implements PharmacyBankAccountInformationRepository {

    private static PharmacyBankAccountInformationRepository repository = null;
    private Set<PharmacyBankAccountInformation> pharmacyBankAccountInformationDB;

    public PharmacyBankAccountInformationImpl(){
        this.pharmacyBankAccountInformationDB = new HashSet<>();
    }

    public static PharmacyBankAccountInformationRepository getRepository(){
        if (repository == null) repository = new PharmacyBankAccountInformationImpl();
        return repository;
    }

    @Override
    public PharmacyBankAccountInformation create(PharmacyBankAccountInformation pharmacyBankAccountInformation) {
        this.pharmacyBankAccountInformationDB.add(pharmacyBankAccountInformation);
        return pharmacyBankAccountInformation;
    }

    @Override
    public PharmacyBankAccountInformation read(String bankinfo) {
        PharmacyBankAccountInformation accountInformation = null;
        for (PharmacyBankAccountInformation u: this.pharmacyBankAccountInformationDB)
            if(u.getBankName().equalsIgnoreCase(bankinfo)){
                accountInformation = u;
            }
            else if(u.getBankAccountId().equalsIgnoreCase(bankinfo))
            {
                accountInformation = u;
            }

        return accountInformation;
    }

    @Override
    public PharmacyBankAccountInformation update(PharmacyBankAccountInformation pharmacyBankAccountInformation) {
        PharmacyBankAccountInformation oldInfo = read(pharmacyBankAccountInformation.getBankAccountId());
        if(oldInfo != null){
            this.pharmacyBankAccountInformationDB.remove(oldInfo);
            this.pharmacyBankAccountInformationDB.add(pharmacyBankAccountInformation);
        }
        return pharmacyBankAccountInformation;
    }

    @Override
    public boolean delete(String pharmacyID) {
        PharmacyBankAccountInformation bankInfo = read(pharmacyID);
        if (pharmacyID != null){
            this.pharmacyBankAccountInformationDB.remove(bankInfo);
            return true;
        }
        return false;
    }

    @Override
    public Set<PharmacyBankAccountInformation> getAll() {
        return this.pharmacyBankAccountInformationDB;
    }
}
*/
