package com.digital.epharmacy.factory.User;
//Nicole Hawthorne- UserProfile factory create a user - 05 July 2020
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.util.GenericHelper;

public class UserProfileFactory {

    public static UserProfile createUserProfile(String userName, String userSurname, String gender){
        String userId = GenericHelper.generateId();
        UserProfile userProfile = new UserProfile.Builder().setUserId(userId)
                .setUserName(userName)
                .setUserSurname(userSurname)
                .setGender(gender)
                .build();
        return userProfile;
    }


}
