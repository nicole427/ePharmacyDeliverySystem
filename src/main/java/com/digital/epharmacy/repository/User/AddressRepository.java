package com.digital.epharmacy.repository.User;

/*
 * Author: Keagan Tabisher
 * Date: 30/08/2020
 * Description: Address Repository class that extends the IRepository class,
 * allows for other less common methods to be used for the userprofile
 * */

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;


public interface AddressRepository extends Repository<Address, String> {
    Set<Address> getAll();
}
