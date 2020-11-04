package com.digital.epharmacy.service.User.impl;

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.repository.User.ContactInformationRepository;
import com.digital.epharmacy.service.User.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    @Autowired
    private ContactInformationRepository repository;


    @Override @Transactional
    public Set<ContactInformation> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override @Transactional
    public ContactInformation create(ContactInformation contactInformation) {
        return this.repository.save(contactInformation);
    }

    @Override @Transactional
    public ContactInformation read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override @Transactional
    public ContactInformation update(ContactInformation contactInformation) {

        if(this.repository.existsById(contactInformation.getcontactId())){
            return this.repository.save(contactInformation);
        }
        return null;
    }

    @Override @Transactional
    public boolean delete(String s) {
         this.repository.deleteById(s);
        if(this.repository.existsById(s))return false;
        else return true;
    }
}
