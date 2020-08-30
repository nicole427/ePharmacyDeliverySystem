package com.digital.epharmacy.repository.PharmacyBankAccountInformation;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation repository
 * Date: 29 August 2020
 */

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

public interface PharmacyBankAccountInformationRepository extends Repository<PharmacyBankAccountInformation, String> {
    Set<PharmacyBankAccountInformation> getAll();
}
