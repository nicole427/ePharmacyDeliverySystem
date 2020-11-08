package com.digital.epharmacy.controller.user;

//Matthew Pearce - UserContactInformation Controller

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.service.User.impl.ContactInformationServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/contactinformation")
public class UserContactInformationController {

    @Autowired
    private ContactInformationServiceImpl contactInformationService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<ContactInformation> create (@Valid @RequestBody ContactInformation contactInformation, BindingResult result){

        ResponseEntity<ContactInformation> errorMap = (ResponseEntity<ContactInformation>) validationService.MapValidationService(result);

   if(errorMap != null){

       return errorMap;
   }

        ContactInformation newContactInformation = ContactInformationFactory.createContactInformation(
                contactInformation.getPrimaryNumber(),
                contactInformation.getSecondaryNumber()
        );

        contactInformationService.create(newContactInformation);
        return new ResponseEntity<ContactInformation>(newContactInformation, HttpStatus.CREATED);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<ContactInformation> read (@PathVariable String userID){

        ContactInformation newContactInformation = contactInformationService.read(userID);
        return new ResponseEntity<ContactInformation>(newContactInformation,HttpStatus.OK);
    }

    @PostMapping("/update")
    public ContactInformation update (@RequestBody ContactInformation contactInformation){
        return contactInformationService.update(contactInformation);
    }

    @GetMapping("/all")
    public Set<ContactInformation> getAll(){
        return contactInformationService.getAll();
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable String userId){
        return contactInformationService.delete(userId);
    }
}
