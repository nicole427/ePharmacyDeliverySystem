package com.digital.epharmacy.service.Driver.impl;
 /*
 * Author: Chad Boswell 215254589
 * Desc: Driver Car Service implementation test
 * Date: 04 September 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.factory.Driver.DriverCarFactory;
import com.digital.epharmacy.service.Driver.DriverCarService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverCarServiceImplTest {

    @Autowired
    private DriverCarService service;

    DriverCar driverCar = DriverCarFactory.createDriverCar("Test","CY 240", "blue", "Ford", "Figo");



    @Test
    public void create() {
        DriverCar created = service.create((driverCar));
        Assert.assertEquals(driverCar.getCarId(), created.getCarId());
        System.out.println("Create: " + created);
    }


    @Test
    public void read() {
        DriverCar read = service.read(driverCar.getCarId());
        System.out.println("Read: " + read);
    }

    @Test
    public void update() {
        DriverCar updated = new DriverCar.Builder().copy(driverCar).setCarName("Golf").builder();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }


    @Test
    public void getAll() {
        Set<DriverCar> car = service.getAll();
        assertNotEquals(150, car.size());
        System.out.println("Driver Cars: " + car);
    }

    @Test
    public void delete() {
        boolean deleted = service.delete(driverCar.getCarId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}