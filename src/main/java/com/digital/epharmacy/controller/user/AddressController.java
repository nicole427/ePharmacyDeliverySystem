package com.digital.epharmacy.controller.user;
// Keagan Tabisher, Address Controller to expose the AddressService.


import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.service.User.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @PostMapping("/create")
    public Address create (@RequestBody Address address)
    {
     Address createdAddress = AddressFactory.createAddress(address.getUserId(),address.getPharmacyId(),
             address.getStreetNumber(),address.getAreaCode(),address.getStreetName(),address.getAreaName());

     return addressService.create(createdAddress);
    }

    @GetMapping("/read/{userId}")
    public Address read(@PathVariable String userId){
        return addressService.read(userId);
    }

    @PostMapping("/update")
    public Address update (@RequestBody Address address){
        return addressService.update(address);
    }

    @GetMapping("/all")
    public Set<Address> getAll(){
        return addressService.getAll();
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable String userId){
        return addressService.delete(userId);
    }
}


