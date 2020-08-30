package com.digital.epharmacy.factory.Pharmacy;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Factory to create Pharmacy
 * Date: 05 July 2020
 */

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.util.GenericHelper;

public class PharmacyFactory {

    public static Pharmacy createPharmacy(String pharmacyName){
        String pharmacyID = GenericHelper.generateId();
        Pharmacy pharmacy = new Pharmacy.Builder().setPharmacyID(pharmacyID)
                .setPharmacyName(pharmacyName)
                .build();
        return pharmacy;
    }
}
