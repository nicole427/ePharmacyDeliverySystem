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
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverCarServiceImplTest {

    private DriverCarService service;
    DriverCar driverCar = DriverCarFactory.createDriverCar("CY 240", "blue", "Ford", "Figo");


    @Order(1)
    @Test
    public void a_create() {
        DriverCar created = service.create((driverCar));
        Assert.assertEquals(driverCar.getCarId(), created.getCarId());
        System.out.println("Create: " + created);
    }

    @Order(2)
    @Test
    public void b_read() {
        DriverCar read = service.read(driverCar.getCarId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    public void c_update() {
        DriverCar updated = new DriverCar.Builder().copy(driverCar).setCarName("Golf").builder();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(4)
    @Test
    public void d_getAll() {
        Set<DriverCar> car = service.getAll();
        assertEquals(1, car.size());
        System.out.println("Pharmacies: " + car);
    }

    @Order(5)
    @Test
    public void e_delete() {
        boolean deleted = service.delete(driverCar.getCarId());
        Assert.assertTrue(deleted);

        if (deleted)
            System.out.println("Entry Deleted");
    }
}