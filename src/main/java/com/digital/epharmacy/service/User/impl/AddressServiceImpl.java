package com.digital.epharmacy.service.User.impl;

import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.repository.User.AddressRepository;
import com.digital.epharmacy.service.User.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public Set<Address> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Address update(Address address) {
        return this.repository.save(address);
    }

    @Override
    public boolean delete(String s)
    {
         this.repository.deleteById(s);
         if (this.repository.existsById(s)) return false;
         return true;
    }



}