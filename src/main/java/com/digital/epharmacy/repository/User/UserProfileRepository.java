package com.digital.epharmacy.repository.User;

import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

public interface UserProfileRepository extends Repository<UserProfile, String> {
Set<UserProfile> getAll();
}
