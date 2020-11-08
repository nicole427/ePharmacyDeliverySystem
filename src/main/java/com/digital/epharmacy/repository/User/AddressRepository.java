package com.digital.epharmacy.repository.User;

/*
 * Author: Keagan Tabisher
 * Date: 30/08/2020
 * Description: Address Repository class that extends the IRepository class,
 * allows for other less common methods to be used for the userprofile
 * */

import com.digital.epharmacy.entity.User.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    Address findAddressByStreetName(String streetName);
}
