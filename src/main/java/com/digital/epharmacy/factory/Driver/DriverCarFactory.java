package com.digital.epharmacy.factory.Driver;
/*
    Author: Chad Boswell
    Desc: DriverCar creates a factory for the car
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.util.GenericHelper;

//still need to retrieve pharmacyId and userId from their actual classes for random ID generation.
public class DriverCarFactory {
    public static DriverCar createDriverCar(String carRegistration, String carColour, String carName, String carModel){

        String carId = GenericHelper.generateId();

        DriverCar driverCar = new DriverCar.Builder()
                .setCarId(carId)
                .setCarRegistration(carRegistration)
                .setCarColour(carColour)
                .setCarName(carName)
                .setCarModel(carModel)
                .builder();
        return driverCar;
    }
}

