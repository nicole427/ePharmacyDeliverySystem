/*
 * Author: Matsobane Nelson Mpyana
 * Desc: PharmacyCatalogueRepository repository
 * Date: 29 August 2020
 */

package com.digital.epharmacy.repository.PharmacyCatalogue;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;


public interface PharmacyCatalogueRepository extends Repository<PharmacyCatalogue, String>{
    Set <PharmacyCatalogue> getAll();
}
