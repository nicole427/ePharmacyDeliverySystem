package com.digital.epharmacy.service.User;

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface ContactInformationService extends IService<ContactInformation, String> {

    Set<ContactInformation>getAll();
}
