package com.digital.epharmacy.repository.User;
/*
 * Author: Nicole Hawthorne
 * Date: 28/08/2020
 * Description: UserProfile Repository class thaat extends the IRepository class,
 * allows for other less common methods to be used for the userprofile
 * */
import com.digital.epharmacy.entity.User.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;
@Repository
public interface UserProfileRepository extends JpaRepository <UserProfile, String> {
    UserProfile findUserProfileByUserName(String userName);
}
