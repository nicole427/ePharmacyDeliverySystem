package com.digital.epharmacy.repository.User;

import com.digital.epharmacy.entity.User.ContactInformation;
import com.digital.epharmacy.repository.Repository;


import java.util.Set;

public interface ContactInformationRepository extends Repository<ContactInformation, String> {

    Set<ContactInformation> getAll();
}
