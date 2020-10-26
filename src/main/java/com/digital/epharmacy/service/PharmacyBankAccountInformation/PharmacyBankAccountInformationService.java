package com.digital.epharmacy.service.PharmacyBankAccountInformation;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.service.IService;

import java.util.Set;
/*
 * Author: Opatile Kelobang
 * Desc: PharrmacyBank Account service
 * Date: 03 September 2020
 */
public interface PharmacyBankAccountInformationService extends IService<PharmacyBankAccountInformation, String> {
    Set<PharmacyBankAccountInformation> getAll();
    PharmacyBankAccountInformation findByAccountNumber(int accountNumber);
}
