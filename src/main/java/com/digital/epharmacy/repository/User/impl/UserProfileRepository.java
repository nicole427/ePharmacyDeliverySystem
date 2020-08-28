package com.digital.epharmacy.repository.User.impl;

import com.digital.epharmacy.entity.User.UserProfile;

import java.util.Set;

public interface UserProfileRepository extends Repository<UserProfile, String> {
Set<UserProfile> getAll();
}
