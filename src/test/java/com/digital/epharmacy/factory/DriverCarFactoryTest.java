package com.digital.epharmacy.factory;
/*
    Author: Chad Boswell
    Desc: DriverCar test case
    Date: 5 July 2020
 */
import com.digital.epharmacy.entity.DriverCar;
import org.junit.Test;

import static org.junit.Assert.*;
// still need to test for random id generated
public class DriverCarFactoryTest {
    @Test
    public void createDriverCar() {
        DriverCar car = DriverCarFactory.createDriverCar("Test","CY 240", "blue", "Ford", "Figo");
        assertEquals("random", car.getDriverId());
        assertEquals("Cy 300", car.getCarRegistration());
        assertEquals("green", car.getCarColour());
        assertEquals("Ford", car.getCarName());
        assertEquals("Fiesta", car.getCarModel());

    }
}