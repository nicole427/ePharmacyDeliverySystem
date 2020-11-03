package com.digital.epharmacy.controller.user;
// Keagan Tabisher, Address Controller to expose the AddressService.


import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.Address;
import com.digital.epharmacy.factory.User.AddressFactory;
import com.digital.epharmacy.service.User.impl.AddressServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<Address> create (@Valid @RequestBody Address address, BindingResult result)
    {
        ResponseEntity<Address> errorMap = (ResponseEntity<Address>) validationService.MapValidationService(result);

        if (errorMap != null)
            return errorMap;

        Address newAddress = AddressFactory.createAddress(
                address.getStreetNumber(),
                address.getAreaCode(),
                address.getStreetName(),
                address.getAreaName()
        );

        addressService.create(newAddress);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }

    @GetMapping("/read/{addressId}")
    public ResponseEntity<?> readbyAddress(@PathVariable String addressId){
        Address address = addressService.read(addressId);

        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @GetMapping("/name/{streetName}")
    public ResponseEntity<?> readByPharmacyName(@PathVariable String streetName){
        Address address = addressService.findAddressByStreetName(streetName);

        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @PostMapping("/update")
    public Address update (@RequestBody Address address){
        return addressService.update(address);
    }

    @GetMapping("/all")
    public Set<Address> getAll(){
        return addressService.getAll();
    }

    @DeleteMapping("/delete/{addressId}")
    public boolean delete(@PathVariable String addressId){
        return addressService.delete(addressId);
    }
}


