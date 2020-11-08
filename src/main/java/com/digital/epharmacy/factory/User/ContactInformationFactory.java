package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - Contact Information Factory - 05 July 2020
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.util.GenericHelper;


// still need to retrieve userId and pharmacyId from their actual classes
public class ContactInformationFactory {

    public static ContactInformation createContactInformation(String primaryNumber, String secondaryNumber){

        String contactId = GenericHelper.generateId();

        ContactInformation contactInformation = new ContactInformation.Builder()
                .setUserId(contactId)
                .setPrimaryNumber(primaryNumber)
                .setSecondaryNumber(secondaryNumber)
                .build();
        return contactInformation;
    }
}
