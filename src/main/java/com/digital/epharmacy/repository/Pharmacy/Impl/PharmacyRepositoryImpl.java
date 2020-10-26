/*package com.digital.epharmacy.repository.Pharmacy.Impl;*/

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.repository.Pharmacy.PharmacyRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy repository implementation
 * Date: 29 August 2020
 */

/*
@Repository
public class PharmacyRepositoryImpl implements PharmacyRepository {
    private static PharmacyRepository repository = null;
    private Set<Pharmacy> pharmacyDB;

    public PharmacyRepositoryImpl()
    {
        this.pharmacyDB = new HashSet<>();
    }

    public static PharmacyRepository getRepository(){
        if (repository == null) repository = new PharmacyRepositoryImpl();
        return repository;
    }

    @Override
    public Pharmacy create(Pharmacy pharmacy) {
        this.pharmacyDB.add(pharmacy);
        return pharmacy;
    }

    @Override
    public Pharmacy read(String pharmacy) {
        Pharmacy name = null;
        for (Pharmacy u: this.pharmacyDB)
            if(u.getPharmacyId().equalsIgnoreCase(pharmacy)) {
                name = u;
            }else if(u.getPharmacyName().equalsIgnoreCase(pharmacy)){
                name = u;
            }

        return name;
    }

    @Override
    public Pharmacy update(Pharmacy pharmacy) {
        Pharmacy oldPharmacy = read(pharmacy.getPharmacyId());
        if(oldPharmacy != null){
            this.pharmacyDB.remove(oldPharmacy);
            this.pharmacyDB.add(pharmacy);
        }
        return pharmacy;
    }

    @Override
    public boolean delete(String pharmacyID) {
        Pharmacy pharmacy = read(pharmacyID);
        if (pharmacyID != null){
            this.pharmacyDB.remove(pharmacy);
            return true;
        }
        return false;
    }

    @Override
    public Set<Pharmacy> getAll() {
        return this.pharmacyDB;
    }
}
*/
