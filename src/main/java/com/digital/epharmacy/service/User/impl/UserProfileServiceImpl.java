package com.digital.epharmacy.service.User.impl;
/*
 * Author: Nicole Hawthorne
 * Date: 02/09/2020
 * Desc: Implementation for all userprofile methods
 * */
import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.User.UserProfileRepository;
import com.digital.epharmacy.service.User.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository repository;


    @Override @Transactional
    public Set<UserProfile> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override @Transactional
    public UserProfile findUserProfileByUserName(String userName) {
        UserProfile newUserProfile = repository.findUserProfileByUserName(userName);
        if (newUserProfile == null)
            throw new MyCustomExceptionHandler("UserName or Id does not exist");

        return newUserProfile;
    }

    @Override @Transactional
    public UserProfile create(UserProfile userProfile) {
        return this.repository.save(userProfile);
    }

    @Override @Transactional
    public UserProfile read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override @Transactional
    public UserProfile update(UserProfile userProfile) {

        if (this.repository.existsById(userProfile.getUserId()))
            return this.repository.save(userProfile);
        return null;
    }

    @Override @Transactional
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;
        else return true;
    }
}
