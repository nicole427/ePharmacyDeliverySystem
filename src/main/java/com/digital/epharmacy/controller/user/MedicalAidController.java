package com.digital.epharmacy.controller.user;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.factory.User.MedicalAidFactory;
import com.digital.epharmacy.service.MedicalAid.impl.MedicalAidServiceImpl;
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
 * Desc: Medical Controller
 * Date: 25 September 2020
 */
@RestController
@RequestMapping("/medicalaid")
public class MedicalAidController {

    @Autowired
    private MedicalAidServiceImpl medicalAidService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<MedicalAid> create(@Valid @RequestBody MedicalAid medicalAid, BindingResult result) {

        ResponseEntity<MedicalAid> errorMap = (ResponseEntity<MedicalAid>) validationService.MapValidationService(result);

        if (errorMap != null)
            return errorMap;

        MedicalAid newMedicalAid = MedicalAidFactory.createMedicalAid(
                medicalAid.getUserMedicalAidNumber(),
                medicalAid.getMedicalAidName(),
                medicalAid.getMedicalAidScheme()
        );

        medicalAidService.create(newMedicalAid);
        return new ResponseEntity<MedicalAid>(medicalAid, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public MedicalAid update(@Valid @RequestBody MedicalAid userId){
        return medicalAidService.update(userId);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<MedicalAid> read(@PathVariable String userId){
        MedicalAid medicalAid = medicalAidService.read(userId);

        return new ResponseEntity<MedicalAid>(medicalAid, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Set<MedicalAid> getAll(){
        return medicalAidService.getAll();
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable String userId){
        return medicalAidService.delete(userId);
    }

}

