package com.digital.epharmacy.service.PharmacyCatalogue;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface PharmacyCatalogueService extends IService<PharmacyCatalogue, String> {
    Set<PharmacyCatalogue> getAll();
}
