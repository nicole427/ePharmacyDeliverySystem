package com.digital.epharmacy.controller.user;

//Matthew Pearce - UserContactInformation Controller

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.factory.User.ContactInformationFactory;
import com.digital.epharmacy.service.User.impl.ContactInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contactinformation")
public class UserContactInformationController {

    @Autowired
    private ContactInformationServiceImpl contactInformationService;

    @PostMapping("/create")
    public ContactInformation create (@RequestBody ContactInformation contactInformation){

        ContactInformation newContactInformation = ContactInformationFactory.createContactInformation(
                contactInformation.getPrimaryNumber(),
                contactInformation.getSecondaryNumber()
        );

        return contactInformationService.create(contactInformation);
    }

    @GetMapping("/read/{userId}")
    public ContactInformation read(@PathVariable String userId){
        return contactInformationService.read(userId);
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
