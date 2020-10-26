package com.digital.epharmacy.factory.Pharmacy;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.util.GenericHelper;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformationFactory Factory to create PharmacyBankAccountInformation
 * Date: 05 July 2020
 */
public class PharmacyBankAccountInformationFactory {
    public static PharmacyBankAccountInformation createPharmacyBankAccountInformation(String bankName, int accountNumber, int branchCode, String beneficiaryReference){
        String banAccountId = GenericHelper.generateId();

        PharmacyBankAccountInformation pharmacyBankAccountInformation = new PharmacyBankAccountInformation.Builder().setBankAccountId(banAccountId)
                .setBankName(bankName)
                .setAccountNumber(accountNumber)
                .setBranchCode(branchCode)
                .setBeneficiaryReference(beneficiaryReference)
                .build();
        return pharmacyBankAccountInformation;
    }
}
