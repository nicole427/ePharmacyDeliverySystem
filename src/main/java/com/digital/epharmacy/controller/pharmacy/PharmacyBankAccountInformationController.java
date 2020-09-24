package com.digital.epharmacy.controller.pharmacy;

import com.digital.epharmacy.entity.Pharmacy.PharmacyBankAccountInformation;
import com.digital.epharmacy.factory.Pharmacy.PharmacyBankAccountInformationFactory;
import com.digital.epharmacy.service.PharmacyBankAccountInformation.PharmacyBankAccountInformationService;
import com.digital.epharmacy.service.PharmacyBankAccountInformation.impl.PharmacyBankAccountInformationServiceImpl;
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
 * Desc: Pharmacy Bank Account Info Controller
 * Date: 24 September 2020
 */
@RestController
@RequestMapping("/bankdetails")
public class PharmacyBankAccountInformationController {

    @Autowired
    private PharmacyBankAccountInformationServiceImpl bankService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<PharmacyBankAccountInformation> create(@Valid @RequestBody PharmacyBankAccountInformation bankinfo, BindingResult result){

        ResponseEntity<PharmacyBankAccountInformation> errorMap = (ResponseEntity<PharmacyBankAccountInformation>) validationService.MapValidationService(result);

        if (errorMap != null)
            return errorMap;

        PharmacyBankAccountInformation newBankInfo = PharmacyBankAccountInformationFactory
                .createPharmacyBankAccountInformation(
                        bankinfo.getPharmacyID(),
                        bankinfo.getBankName(),
                        bankinfo.getAccountNumber(),
                        bankinfo.getBranchCode(),
                        bankinfo.getBeneficiaryReference()
                );

        bankService.create(newBankInfo);

        return new ResponseEntity<PharmacyBankAccountInformation>(bankinfo, HttpStatus.CREATED);
    }

    @GetMapping("/read/{pharmacyID}")
    public ResponseEntity<PharmacyBankAccountInformation> read(@PathVariable String pharmacyID){
        PharmacyBankAccountInformation bankInfo = bankService.read(pharmacyID);

        return new ResponseEntity<PharmacyBankAccountInformation>(bankInfo, HttpStatus.OK);
    }

    @PostMapping("/update")
    public PharmacyBankAccountInformation update(@Valid @RequestBody PharmacyBankAccountInformation bankInfo){
        return bankService.update(bankInfo);
    }

    @GetMapping("/all")
    public Set<PharmacyBankAccountInformation> getall(){
        return bankService.getAll();
    }

    @DeleteMapping("/delete/{pharmacyID}")
    public boolean delete(@PathVariable String pharmacyID){
        return bankService.delete(pharmacyID);
    }
}
