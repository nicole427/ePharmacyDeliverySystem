package com.digital.epharmacy.factory;
//Nicole Hawthorne - Adding contact information - 05 July
import com.digital.epharmacy.entity.ContactInformation;
import com.digital.epharmacy.entity.MedicalAid;
import com.digital.epharmacy.util.GenericHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactInformationFactoryTest {
// must still retrieve userid and pharmacyid from their actual classees for random id
    //must still choose appropriate data type for cell number
    @Test
    public void createContactInformation() {
        ContactInformation contactInformation = ContactInformationFactory.createContactInformation(GenericHelper.generateId(),"Random",891271,072171);
        assertEquals("", contactInformation.getUserId());
        assertEquals("Random", contactInformation.getPharmacyId());
        assertEquals(123456, contactInformation.getPrimaryNumber());
        assertEquals(123456, contactInformation.getSecondaryNumber());
    }
}