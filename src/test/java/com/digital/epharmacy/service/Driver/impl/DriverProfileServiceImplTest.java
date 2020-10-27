package com.digital.epharmacy.service.Driver.impl;
 /*
 * Chad Boswell 215254589
 * Date: 04/09/2020
 * Desc: Test case for DriverProfileService Implementation
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
import com.digital.epharmacy.service.Driver.DriverProfileService;
import com.digital.epharmacy.service.Driver.impl.DriverProfileServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverProfileServiceImplTest {

    private static DriverProfileService service;
    private static DriverProfile driverProfile = DriverProfileFactory.createDriverProfile("Chaddy","Boswell","Bellville");
    @Order(4)
    @Test
    void d_getAll() {
        Set<DriverProfile> driverProfile = service.getAll();
        assertEquals(1,driverProfile.size());
        System.out.println("All users" + driverProfile);
    }
    @Order(1)
    @Test
    void a_create() {
        DriverProfile created = service.create(driverProfile);
        assertEquals(driverProfile.getDriverId(), created.getDriverId());
        System.out.println("Driver ID created" + created);
    }
    @Order(2)
    @Test
    void b_read() {
        DriverProfile read = service.read(driverProfile.getDriverId());
        assertEquals(driverProfile.getDriverId(),read.getDriverId());
        System.out.println("Read: " + read);
    }
    @Order(3)
    @Test
    void c_update() {
        DriverProfile updated = new DriverProfile.Builder().copy(driverProfile).setDriverName("Chaddo").setDriverSurname("Boswell").builder();
        updated = service.update(updated);
        System.out.println("Updated Driver" + updated);
    }
    @Order(5)
    @Test
    void e_delete() {
        boolean deleted = service.delete(driverProfile.getDriverId());
        Assert.assertTrue(deleted);
        System.out.println("Driver Deleted");
    }
}