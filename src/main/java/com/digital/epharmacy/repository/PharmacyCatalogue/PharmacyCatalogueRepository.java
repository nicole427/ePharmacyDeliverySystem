/*
 * Author: Matsobane Nelson Mpyana
 * Desc: PharmacyCatalogueRepository repository
 * Date: 29 August 2020
 */

package com.digital.epharmacy.repository.PharmacyCatalogue;

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PharmacyCatalogueRepository extends JpaRepository<PharmacyCatalogue, String> {

}
