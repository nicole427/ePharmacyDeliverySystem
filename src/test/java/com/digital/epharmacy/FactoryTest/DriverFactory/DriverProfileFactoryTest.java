package com.digital.epharmacy.FactoryTest.DriverFactory;
/*
    Author: Chad Boswell
    Desc: Driver test case
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverProfileFactoryTest {

    @Test
    public void createUserProfile() {
        DriverProfile driverProfile = DriverProfileFactory.createDriverProfile("Chaddy","Hawthorne","Bellville");
        assertEquals("1001", driverProfile.getDriverId());
        assertEquals("Chad", driverProfile.getDriverName());
        assertEquals("Boswell", driverProfile.getDriverSurname());
        assertEquals("Cape Town", driverProfile.getDriverLocation());

    }
}