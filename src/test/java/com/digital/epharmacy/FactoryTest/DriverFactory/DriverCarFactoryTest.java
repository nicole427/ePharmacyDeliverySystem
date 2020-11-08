package com.digital.epharmacy.FactoryTest.DriverFactory;
/*
    Author: Chad Boswell
    Desc: DriverCar test case
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.factory.Driver.DriverCarFactory;
import org.junit.Test;

import static org.junit.Assert.*;
// still need to test for random id generated
public class DriverCarFactoryTest {
    @Test
    public void createDriverCar() {
        DriverCar car = DriverCarFactory.createDriverCar("CY 240", "blue", "Ford", "Figo");
        assertEquals("random", car.getCarId());
        assertEquals("Cy 300", car.getCarRegistration());
        assertEquals("green", car.getCarColour());
        assertEquals("Ford", car.getCarName());
        assertEquals("Fiesta", car.getCarModel());

    }
}