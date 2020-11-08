package com.digital.epharmacy.controller.Catalogue;
/*
 * Name: Nelson Mpyana
 * Desc: Pharmacy Catalogue Item controller
 * Date: 09/26/2020
 */

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.factory.Catalogue.PharmacyCatalogueFactory;
import com.digital.epharmacy.service.PharmacyCatalogue.impl.PharmacyCatalogueServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

public class PharmacyCatalogueController {

    @Autowired
    private PharmacyCatalogueServiceImpl catalogueService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<PharmacyCatalogue> create(@Valid @RequestBody PharmacyCatalogue catalogue, BindingResult result){

        ResponseEntity<PharmacyCatalogue> errorMap = (ResponseEntity<PharmacyCatalogue>) validationService.MapValidationService(result);

        if (errorMap != null)
            return errorMap;

        PharmacyCatalogue newCatalogue = PharmacyCatalogueFactory
                .createPharmacyCatalogue(
                        catalogue.getCatalogueName(),
                        catalogue.getCatalogueDescription()
                );

        catalogueService.create(newCatalogue);

        return new ResponseEntity<PharmacyCatalogue>(catalogue, HttpStatus.CREATED);
    }
    @GetMapping("/read/{pharmacyID}")
    public ResponseEntity<PharmacyCatalogue> read(@PathVariable String pharmacyID) {
        PharmacyCatalogue cat = catalogueService.read(pharmacyID);

        return new ResponseEntity<PharmacyCatalogue>(cat, HttpStatus.OK);
    }

    @PostMapping("/update")
    public PharmacyCatalogue update(@Valid @RequestBody PharmacyCatalogue catInfo){
        return catalogueService.update(catInfo);
    }
    @GetMapping("/all")
    public Set<PharmacyCatalogue> getall(){
        return catalogueService.getAll();
    }

    @DeleteMapping("/delete/{pharmacyID}")
    public boolean delete(@PathVariable String pharmacyID){
        return catalogueService.delete(pharmacyID);
    }
}
