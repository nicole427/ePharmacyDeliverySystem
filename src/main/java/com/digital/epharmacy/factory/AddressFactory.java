package com.digital.epharmacy.factory;
//Nicole Hawthorne - AddresFactory - 05 July

import com.digital.epharmacy.entity.Pharmacy;
import com.digital.epharmacy.entity.UserProfile;
import com.digital.epharmacy.entity.Address;
//still need to retrieve pharmacyId and userId from their actual classes for random ID generation.
public class AddressFactory {
    public static Address createAddress(String pharmacyId, String userId, int streetNumber, int areaCode, String streetName, String areaName){
        Address address = new Address.Builder()
                .setPharmacyId(pharmacyId)
                .setUserId(userId)
                .setStreetName(streetName)
                .setStreetNumber(streetNumber)
                .setAreaCode(areaCode)
                .setAreaName(areaName)
                .build();
        return address;
    }
}
