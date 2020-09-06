
package com.digital.epharmacy.service.PharmacyCatalogue.impl;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.repository.PharmacyCatalogue.Impl.PharmacyCatalogueRepositoryImpl;
import com.digital.epharmacy.repository.PharmacyCatalogue.PharmacyCatalogueRepository;
import com.digital.epharmacy.service.PharmacyCatalogue.PharmacyCatalogueService;

import java.util.Set;

public class PharmacyCatalogueServiceImpl implements PharmacyCatalogueService {
    public static PharmacyCatalogueService service = null;
    private PharmacyCatalogueRepository repository;

    private PharmacyCatalogueServiceImpl(){
        this.repository = PharmacyCatalogueRepositoryImpl.getRepository();
    }

    public static PharmacyCatalogueService getService(){
        if(service == null) service = new PharmacyCatalogueServiceImpl();
        return service;
    }

    @Override
    public Set<PharmacyCatalogue> getAll() {
        return this.repository.getAll();
    }

    @Override
    public PharmacyCatalogue create(PharmacyCatalogue pharmacyCatalogue) {
        return this.repository.create(pharmacyCatalogue);
    }

    @Override
    public PharmacyCatalogue read(String s) {
        return this.repository.read(s);
    }

    @Override
    public PharmacyCatalogue update(PharmacyCatalogue pharmacyCatalogue) {
        return this.repository.update(pharmacyCatalogue);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
