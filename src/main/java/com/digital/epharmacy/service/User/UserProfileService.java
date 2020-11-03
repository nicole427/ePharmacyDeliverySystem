package com.digital.epharmacy.service.User;
/*
 * Author: Nicole Hawthorne 217169104
 * Date: 02/09/2020
 * Desc: UserProfile Service interface that extends the main interface.
 * To add commonly used method only applicable to userProfile
 * */
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.service.IService;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface UserProfileService extends IService <UserProfile , String> {
    Set<UserProfile> getAll();
    UserProfile findUserProfileByUserName(String userName);;
}
