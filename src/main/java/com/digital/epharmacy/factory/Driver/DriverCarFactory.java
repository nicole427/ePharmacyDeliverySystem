package com.digital.epharmacy.factory.Driver;
/*
    Author: Chad Boswell
    Desc: DriverCar creates a factory for the car
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;

//still need to retrieve pharmacyId and userId from their actual classes for random ID generation.
public class DriverCarFactory {
    public static DriverCar createDriverCar(String driverId, String carRegistration, String carColour, String carName, String carModel){
        DriverCar driverCar = new DriverCar.Builder()
                .setDriverId(driverId)
                .setCarRegistration(carRegistration)
                .setCarColour(carColour)
                .setCarName(carName)
                .setCarModel(carModel)
                .builder();
        return driverCar;
    }
}

