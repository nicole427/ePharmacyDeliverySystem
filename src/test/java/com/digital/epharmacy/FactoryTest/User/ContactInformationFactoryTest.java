package com.digital.epharmacy.FactoryTest.User;
//Nicole Hawthorne - Adding contact information - 05 July
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.util.GenericHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactInformationFactoryTest {
// must still retrieve userid and pharmacyid from their actual classees for random id
    //must still choose appropriate data type for cell number
    @Test
    public void createContactInformation() {
        ContactInformation contactInformation = ContactInformationFactory.createContactInformation("0812417892","0214478793");
        assertEquals("0812417892", contactInformation.getPrimaryNumber());
        assertEquals("0214478793", contactInformation.getSecondaryNumber());
    }
}