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
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserProfileServiceImplTest {

    @Autowired
    private UserProfileService service;
    private static UserProfile userProfile = UserProfileFactory.createUserProfile("Nicole","Hawthorne","F");

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
        Assert.assertEquals(userProfile.getUserId(), created.getUserId());
        System.out.println("User ID created" + created);
    }

    @Order(2)
    @Test
    void b_read() {
        UserProfile read = service.read(userProfile.getUserId());
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
        if (deleted)
            System.out.println("User Deleted");
    }
}