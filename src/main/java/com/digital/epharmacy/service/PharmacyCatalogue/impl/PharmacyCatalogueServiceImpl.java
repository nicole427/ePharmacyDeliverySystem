
package com.digital.epharmacy.service.PharmacyCatalogue.impl;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.repository.PharmacyCatalogue.PharmacyCatalogueRepository;
import com.digital.epharmacy.service.PharmacyCatalogue.PharmacyCatalogueService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

public class PharmacyCatalogueServiceImpl implements PharmacyCatalogueService {

    private PharmacyCatalogueRepository repository;

    @Override @Transactional
    public Set<PharmacyCatalogue> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override @Transactional
    public PharmacyCatalogue create(PharmacyCatalogue pharmacyCatalogue) {
        return this.repository.save(pharmacyCatalogue);
    }

    @Override @Transactional
    public PharmacyCatalogue read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override @Transactional
    public PharmacyCatalogue update(PharmacyCatalogue pharmacyCatalogue) {
        return create(pharmacyCatalogue);
    }

    @Override @Transactional
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)){
            return false;
        } else {
            return true;
        }
    }
}
