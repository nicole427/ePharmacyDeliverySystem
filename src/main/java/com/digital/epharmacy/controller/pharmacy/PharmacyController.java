package com.digital.epharmacy.controller.pharmacy;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.factory.Pharmacy.PharmacyFactory;
import com.digital.epharmacy.service.Pharmacy.impl.PharmacyServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy Controller
 * Date: 24 September 2020
 *
 * Modified: 26 October 2020
 * Updated Method call for Read by Pharmacy name
 *
 */
@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    private PharmacyServiceImpl pharmacyService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<Pharmacy> create(@Valid @RequestBody Pharmacy pharmacy, BindingResult result){

        ResponseEntity<Pharmacy> errorMap = (ResponseEntity<Pharmacy>) validationService.MapValidationService(result);

        if (errorMap != null)
            return errorMap;

        Pharmacy newPharmacy = PharmacyFactory.createPharmacy(pharmacy.getPharmacyName());
        pharmacyService.create(newPharmacy);

        return new ResponseEntity<Pharmacy>(pharmacy, HttpStatus.CREATED);

    }

    @GetMapping("/id/{pharmacyId}")
    public ResponseEntity<?> readByPharmacyID(@PathVariable String pharmacyId){
        Pharmacy pharmacy = pharmacyService.read(pharmacyId);

        return new ResponseEntity<Pharmacy>(pharmacy, HttpStatus.OK);
    }

    @GetMapping("/name/{pharmacyName}")
    public ResponseEntity<?> readByPharmacyName(@PathVariable String pharmacyName){
        Pharmacy pharmacy = pharmacyService.findPharmacyByPharmacyName(pharmacyName);

        return new ResponseEntity<Pharmacy>(pharmacy, HttpStatus.OK);
    }

    @PostMapping("/update")
    public Pharmacy update(@Valid @RequestBody Pharmacy pharmacy){
        return pharmacyService.update(pharmacy);
    }

    @GetMapping("/all")
    public Set<Pharmacy> getAll(){
        return pharmacyService.getAll();
    }
    
    @DeleteMapping("/delete/{pharmacyId}")
    public boolean delete(@PathVariable String pharmacyId){
        return pharmacyService.delete(pharmacyId);
    }
    

}
