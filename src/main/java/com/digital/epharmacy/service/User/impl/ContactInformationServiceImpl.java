package com.digital.epharmacy.service.User.impl;

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.repository.User.ContactInformationRepository;
import com.digital.epharmacy.repository.User.impl.ContactInformationRepositoryImpl;
import com.digital.epharmacy.service.User.ContactInformationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    private static ContactInformationService service = null;
    private ContactInformationRepository repository;

    private ContactInformationServiceImpl(){this.repository = ContactInformationRepositoryImpl.getRepository();}

    public static ContactInformationService getService(){

        if(service == null)
            service = new ContactInformationServiceImpl();

        return service;
    }

    @Override
    public Set<ContactInformation> getAll() {
        return this.repository.getAll();
    }

    @Override
    public ContactInformation create(ContactInformation contactInformation) {
        return this.repository.create(contactInformation);
    }

    @Override
    public ContactInformation read(String s) {
        return this.repository.read(s);
    }

    @Override
    public ContactInformation update(ContactInformation contactInformation) {
        return this.repository.update(contactInformation);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
