package com.digital.epharmacy.service.User.impl;
/*
* Author: Nicole Hawthorne
* Date: 02/09/2020
* Desc: Implementation for all userprofile methods
* */
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.User.UserProfileRepository;
import com.digital.epharmacy.repository.User.impl.UserProfileRepositoryImpl;
import com.digital.epharmacy.service.User.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private static UserProfileService service = null;
    private UserProfileRepository repository;

    private UserProfileServiceImpl() {
    this.repository = UserProfileRepositoryImpl.getRepository();
    }

    public static UserProfileService getService(){
        if(service == null)
           service = new UserProfileServiceImpl();
        return  service;
    }

    @Override
    public Set<UserProfile> getAll() {
        return this.repository.getAll();
    }

    @Override
    public UserProfile create(UserProfile userProfile) {
        return this.repository.create(userProfile);
    }

    @Override
    public UserProfile read(String s) {
        return this.repository.read(s);
    }

    @Override
    public UserProfile update(UserProfile userProfile) {
        return this.repository.update(userProfile);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
