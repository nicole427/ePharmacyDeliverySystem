package com.digital.epharmacy.repository.Pharmacy;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.repository.Repository;


import java.util.Set;

/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy repository
 * Date: 29 August 2020
 */
public interface PharmacyRepository extends Repository<Pharmacy, String> {
    Set<Pharmacy> getAll();
}
