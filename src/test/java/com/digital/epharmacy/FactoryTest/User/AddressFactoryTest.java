package com.digital.epharmacy.FactoryTest.User;
//Nicole Hawthorne: Test Address - 05 July
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.factory.User.AddressFactory;
import org.junit.Test;

import static org.junit.Assert.*;
// still need to test for random id generated
public class AddressFactoryTest {
    @Test
    public void createAddress() {
        Address address = AddressFactory.createAddress(11, 7500, "Berold", "Parow" );
        assertEquals("random", address.getAddressId());
        assertEquals("random", address.getAddressId());
        assertEquals("11", address.getStreetNumber());
        assertEquals("7500", address.getAreaCode());
        assertEquals("Berold", address.getStreetName());
        assertEquals("Parow", address.getAreaName());

    }
}