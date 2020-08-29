package com.digital.epharmacy.factory.Driver;
/*
    Author: Chad Boswell
    Desc: DriverProfile factory that creates a driver
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.util.GenericHelper;

public class DriverProfileFactory {

    public static DriverProfile createDriverProfile(String driverName, String driverSurname, String driverLocation){
        String driverId = GenericHelper.generateId();
        DriverProfile driverProfile = new DriverProfile.Builder().setDriverId(driverId)
                .setDriverName(driverName)
                .setDriverSurname(driverSurname)
                .setDriverLocation(driverLocation)
                .builder();
        return driverProfile;
    }
}