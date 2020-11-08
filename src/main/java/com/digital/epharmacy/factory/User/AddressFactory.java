package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - AddresFactory - 05 July

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.util.GenericHelper;

//still need to retrieve pharmacyId and userId from their actual classes for random ID generation.
public class AddressFactory {
    public static Address createAddress(int streetNumber, int areaCode, String streetName, String areaName){
        String addressId = GenericHelper.generateId();

        Address address = new Address.Builder()
                .setAddressId(addressId)
                .setStreetName(streetName)
                .setStreetNumber(streetNumber)
                .setAreaCode(areaCode)
                .setAreaName(areaName)
                .build();

        return address;
    }
}
