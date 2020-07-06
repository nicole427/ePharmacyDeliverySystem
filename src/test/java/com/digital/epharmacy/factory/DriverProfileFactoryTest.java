package com.digital.epharmacy.factory;
/*
    Author: Chad Boswell
    Desc: DriverProfile test case
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.DriverProfile;
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