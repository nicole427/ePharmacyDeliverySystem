package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - Contact Information Factory - 05 July 2020
import com.digital.epharmacy.entity.User.ContactInformation;


// still need to retrieve userId and pharmacyId from their actual classes
public class ContactInformationFactory {

    public static ContactInformation createContactInformation(String userId, String pharmacyId, int primaryNumber, int secondaryNumber){
        ContactInformation contactInformation = new ContactInformation.Builder()
                .setUserId(userId)
                .setPharmacyId(pharmacyId)
                .setPrimaryNumber(primaryNumber)
                .setSecondaryNumber(secondaryNumber)
                .build();
        return contactInformation;
    }
}
