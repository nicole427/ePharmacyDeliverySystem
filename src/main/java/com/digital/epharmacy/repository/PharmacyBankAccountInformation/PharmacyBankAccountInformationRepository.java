package com.digital.epharmacy.repository.PharmacyBankAccountInformation;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation repository
 * Date: 29 August 2020
 *
 * 26 October 2020
 * Extends JPA Repository
 * Deprecated IRepository
 */

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PharmacyBankAccountInformationRepository extends JpaRepository<PharmacyBankAccountInformation, String> {
    PharmacyBankAccountInformation findByAccountNumber(int accountNumber);
}
