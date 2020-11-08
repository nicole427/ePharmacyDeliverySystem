package com.digital.epharmacy.controller.Catalogue;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.factory.Catalogue.CatalogueItemFactory;
import com.digital.epharmacy.factory.Catalogue.PrescriptionItemFactory;
import com.digital.epharmacy.service.CatalogueItem.impl.CatalogueItemServiceImpl;
import com.digital.epharmacy.service.PrescriptionItem.impl.PrescriptionItemServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

public class  PrescriptionItemController {
    @Autowired
    private PrescriptionItemServiceImpl prescriptionItemService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<PrescriptionItem> create(@Valid @RequestBody PrescriptionItem prescriptionItem, BindingResult result){

        ResponseEntity<PrescriptionItem> errorMap = (ResponseEntity<PrescriptionItem>) validationService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        PrescriptionItem newPrescriptionItem = PrescriptionItemFactory
                .createPrescriptionItem(
                        prescriptionItem.getPrescriptionNumber(),
                        prescriptionItem.getPrescribingDoctor(),
                        prescriptionItem.getPrescriptionType()

                );

        prescriptionItemService.create(newPrescriptionItem);

        return new ResponseEntity<PrescriptionItem>(prescriptionItem, HttpStatus.CREATED);
    }
    @GetMapping("/read/{prescriptionNumber}")
    public ResponseEntity<PrescriptionItem> read(@PathVariable String prescriptionNumber) {
        PrescriptionItem prescriptionItem = prescriptionItemService.read(prescriptionNumber);
        return new ResponseEntity<PrescriptionItem>(prescriptionItem, HttpStatus.OK);
    }
    @PostMapping("/update")
    public PrescriptionItem update(@Valid @RequestBody PrescriptionItem prescriptionItemInfo){
        return prescriptionItemService.update(prescriptionItemInfo);
    }
    @GetMapping("/all")
    public Set<PrescriptionItem> getall(){
        return prescriptionItemService.getAll();
    }

    @DeleteMapping("/delete/{prescriptionNumber}")
    public boolean delete(@PathVariable String prescriptionNumber){
        return prescriptionItemService.delete(prescriptionNumber);
    }
}

