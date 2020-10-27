//package com.digital.epharmacy.repository.Driver.impl;
///*
// * Author: Chad Boswell
// * Date: 30/08/2020
// * Desc: DriverProfileRepository Test
// */
//
//
//import com.digital.epharmacy.entity.Driver.DriverProfile;
//import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
//import com.digital.epharmacy.repository.Driver.DriverProfileRepository;
//import com.digital.epharmacy.repository.Driver.impl.DriverProfileRepositoryImpl;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class DriverProfileRepositoryImplTest {
//    private static DriverProfileRepository repository = new DriverProfileRepositoryImpl();
//    private static DriverProfile  driverProfile = DriverProfileFactory.createDriverProfile(
//            "Chaddo",
//            "Bossi",
//            "Male");
//    @Order(1)
//    @Test
//    public void a_create() {
//        DriverProfile created = repository.create(driverProfile);
//        assertEquals(driverProfile.getDriverId(), created.getDriverId());
//        System.out.println("Create: " + created);
//    }
//
//    @Order(2)
//    @Test
//    public void b_read() {
//        DriverProfile read = repository.read(driverProfile.getDriverId());
//        assertEquals(driverProfile.getDriverId(),read.getDriverId());
//        System.out.println("Read: " + read);
//    }
//
//    @Order(3)
//    @Test
//    public void c_update() {
//        DriverProfile updated = new DriverProfile.Builder().copy(driverProfile).setDriverName("Barry").setDriverSurname("Bossi").builder();
//        updated = repository.update(updated);
//        assertEquals(driverProfile.getDriverId(), updated.getDriverId());
//        assertNotEquals(driverProfile.getDriverName(), updated.getDriverName());
//        System.out.println("Update: " + updated );
//    }
//
//    @Order(5)
//    @Test
//    public void e_delete() {
//        boolean deleted =   repository.delete(driverProfile.getDriverId());
//        Assert.assertTrue(deleted);
//        if (deleted){
//            System.out.println("Entry deleted");
//        }
//    }
//
//    @Order(4)
//    @Test
//    public void d_getAll() {
//        Set<DriverProfile> driverProfile = repository.getAll();
//        assertEquals(1, driverProfile.size());
//        System.out.println(repository.getAll());
//    }
//}