package com.digital.epharmacy.service.User.impl;
/*
* Nicole Hawthorne 217169104
* Date: 02/09/2020
* Desc: Test case for UserProfileService Implementation
* */
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import com.digital.epharmacy.service.User.UserProfileService;
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
public class UserProfileServiceImplTest {

private static UserProfileService service = UserProfileServiceImpl.getService();
private static UserProfile userProfile = UserProfileFactory.createUserProfile("Nicole","Hawthorne","M");
    @Order(4)
    @Test
    void d_getAll() {
        Set<UserProfile> userProfile = service.getAll();
        assertEquals(1,userProfile.size());
        System.out.println("All users" + userProfile);
    }
    @Order(1)
    @Test
    void a_create() {
        UserProfile created = service.create(userProfile);
        assertEquals(userProfile.getUserId(), created.getUserId());
        System.out.println("User ID created" + created);
    }
    @Order(2)
    @Test
    void b_read() {
        UserProfile read = service.read(userProfile.getUserId());
        assertEquals(userProfile.getUserId(),read.getUserId());
        System.out.println("Read: " + read);
    }
    @Order(3)
    @Test
    void c_update() {
        UserProfile updated = new UserProfile.Builder().copy(userProfile).setUserName("Inneke").setGender("F").build();
        updated = service.update(updated);
        System.out.println("Updated User" + updated);
    }
    @Order(5)
    @Test
    void e_delete() {
        boolean deleted = service.delete(userProfile.getUserId());
        Assert.assertTrue(deleted);
        System.out.println("User Deleted");
    }
}