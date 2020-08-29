package com.digital.epharmacy.FactoryTest.User;
//Nicole Hawthorne - Test to create new userprofile - 05 July 2020
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.factory.User.UserProfileFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileFactoryTest {

    @Test
    public void createUserProfile() {
        UserProfile userProfile = UserProfileFactory.createUserProfile("Opatile","Hawthorne","F");
        assertEquals("1000", userProfile.getUserId());
        assertEquals("Nicole", userProfile.getUserName());
        assertEquals("Hawthorne", userProfile.getUserSurname());
        assertEquals("F", userProfile.getGender());

    }
}