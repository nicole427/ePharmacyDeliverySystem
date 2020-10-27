//package com.digital.epharmacy.repository.Driver.impl;
/*
//    Author: Chad Boswell
//    Desc: DriverCar repository test case
//    Date: 30th August 2020
// */
//import com.digital.epharmacy.entity.Driver.DriverCar;
//import com.digital.epharmacy.entity.User.UserProfile;
//import com.digital.epharmacy.factory.Driver.DriverCarFactory;
//import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
//import com.digital.epharmacy.factory.User.UserProfileFactory;
//import com.digital.epharmacy.repository.Driver.impl.DriverCarRepositoryImpl;
//import com.digital.epharmacy.repository.Driver.DriverCarRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runners.MethodSorters;
//
//import static org.junit.Assert.*;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class DriverCarRepositoryImplTest {
//
//    private static DriverCarRepository repository = DriverCarRepositoryImpl.getRepository();
//    private static DriverCar driverCar = DriverCarFactory.createDriverCar("Test","CY 240", "blue", "Ford", "Figo");
//
//    @Order(1)
//    @Test
//    public void a_create() {
//        DriverCar created = repository.create(driverCar);
//        Assert.assertEquals(driverCar.getDriverId(), created.getDriverId());
//        System.out.println("Created: " + created);
//    }
//
//    @Order(2)
//    @Test
//    public void b_read() {
//        DriverCar read = repository.read(driverCar.getDriverId());
//        System.out.println("Read: " + read);
//    }
//
//    @Order(3)
//    @Test
//    public void c_update() {
//        DriverCar updated = new DriverCar.Builder().copy(driverCar).setCarName("Toyota").builder();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Order(5)
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(driverCar.getDriverId());
//        Assert.assertTrue(deleted);
//
//        if (deleted)
//            System.out.println("Entry Deleted");
//    }
//
//    @Order(4)
//    @Test
//    public void d_getAll() {
//        System.out.println("Get All: " + repository.getAll());
//    }
//}
//