package com.digital.epharmacy.repository.User;
/*
* Author: Nicole Hawthorne
* Date: 28/08/2020
* Description: UserProfile Repository class thaat extends the IRepository class,
* allows for other less common methods to be used for the userprofile
* */
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.Repository;


import java.util.Set;

public interface UserProfileRepository extends Repository<UserProfile, String> {
Set<UserProfile> getAll();
}
