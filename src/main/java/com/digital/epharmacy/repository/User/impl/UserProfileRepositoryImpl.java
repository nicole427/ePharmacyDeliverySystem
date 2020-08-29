package com.digital.epharmacy.repository.User.impl;

import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.User.UserProfileRepository;

import java.util.HashSet;
import java.util.Set;

/** Author: Nicole Hawthorne 217169104
 * Date: 28/08/2020
 * Description: UserProfile Repository to create, delete and update a user profile
 */
public class UserProfileRepositoryImpl implements UserProfileRepository {
    private Set<UserProfile> userProfileDB;

    public UserProfileRepositoryImpl() {
        this.userProfileDB = new HashSet<>();
    }
@Override
    public UserProfile create (UserProfile userProfile){
        this.userProfileDB.add(userProfile);
        return userProfile;
    }
@Override
    public UserProfile read (String userId){
        UserProfile userProfile = null;
        for (UserProfile u: this.userProfileDB)
            if (u.getUserId().equalsIgnoreCase(userId) ) {
                userProfile = u;
                break;
            }
        return userProfile;
    }
@Override
    public UserProfile update (UserProfile userProfile){
        UserProfile oldUserProfile = read(userProfile.getUserId());
        if (oldUserProfile != null ){
            this.userProfileDB.remove(oldUserProfile);
            this.userProfileDB.add(userProfile);

        }
        return userProfile;
    }
@Override
    public boolean delete (String userId){
    UserProfile userProfile = read(userId);
    if (userId != null ){
        this.userProfileDB.remove(userProfile);
        return true;
    }
    return false;
    }

    @Override
    public Set<UserProfile> getAll() {
        return this.userProfileDB;
    }
}

