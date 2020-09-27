package com.digital.epharmacy.service.User.impl;

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.repository.User.AddressRepository;
import com.digital.epharmacy.repository.User.impl.AddressRepositoryImpl;
import com.digital.epharmacy.service.User.AddressService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    private static AddressService service = null;
    private AddressRepository repository;

    private AddressServiceImpl() { this.repository = AddressRepositoryImpl.getRepository();}

    public static AddressService getService() {
        if (service == null)
            service = new AddressServiceImpl();
        return service;
    }

    @Override
    public Set<Address> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Address create(Address address) {
        return this.repository.create(address);
    }

    @Override
    public Address read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Address update(Address address) {
        return this.repository.update(address);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }



}