/*package com.digital.epharmacy.repository.User.impl;

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.UserProfile;
import com.digital.epharmacy.repository.User.AddressRepository;
import com.digital.epharmacy.repository.User.ContactInformationRepository;

import java.util.HashSet;
import java.util.Set;*/


/** Author: Keagan Tabisher 215028597
 * Date: 30/08/2020
 * Description: Address Repository to create, delete and update a user profile
 */



/*
public class AddressRepositoryImpl implements AddressRepository {
    private Set<Address> AddressDB;

    private static AddressRepository repository = null;
    public AddressRepositoryImpl() {this.AddressDB = new HashSet<>(); }

    public static AddressRepository getRepository() {

        if(repository == null) repository = new AddressRepositoryImpl();
        return  repository;
    }

    @Override
    public Address create (Address address){
        this.AddressDB.add(address);
        return address;
    }

    @Override
    public Address read (String userId){
        Address address = null;
        for (Address u: this.AddressDB)
            if (u.getUserId().equalsIgnoreCase(userId) ) {
                address = u;
                break;
            }
        return address;
    }

    @Override
    public Address update (Address address){
        Address oldAddress = read(address.getUserId());
        if (oldAddress != null ){
            this.AddressDB.remove(oldAddress);
            this.AddressDB.add(address);

        }
        return address;
    }

    @Override
    public boolean delete (String userId){
        Address address = read(userId);
        if (userId != null ){
            this.AddressDB.remove(address);
            return true;
        }
        return false;
    }

    @Override
    public Set<Address> getAll() {
        return this.AddressDB;
    }
}


*/
