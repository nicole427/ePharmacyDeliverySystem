package com.digital.epharmacy.service.User.impl;
/*
* Author: Nicole Hawthorne
* Date: 02/09/2020
* Desc: Implementation for all userprofile methods
*
* Author: Nicole Hawthorne
* Date: 27/10/2020
* Desc - Auto wired the userProfile Repository. Marked Service class as a service for JPA to read and changed the
* to update, delete, create that uses JPA functions.
* */
import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.User.UserProfileRepository;
import com.digital.epharmacy.service.User.UserProfileService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserProfileServiceImpl implements UserProfileService {


    @Autowired
    private UserProfileRepository repository;


    @Override
    public Set<UserProfile> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public UserProfile create(UserProfile userProfile) {
        return this.repository.save(userProfile);
    }

    @Override
    public UserProfile read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public UserProfile readByUserProfileName(String userName) {
        UserProfile newUserProfile = repository.readByUserProfileName(userName);

        if (newUserProfile == null)
            throw new MyCustomExceptionHandler("Username name or id does not exist");

        return newUserProfile;
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        if (this.repository.existsById(userProfile.getUserId())){
        return this.repository.save(userProfile);}

        return null;
    }

    @Override
    public boolean delete(String s) {
         this.repository.deleteById(s);
         if (this.repository.existsById(s)) return false;
         else return  true;
    }
}
