package com.digital.epharmacy.repository.User;

import com.digital.epharmacy.entity.User.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, String> {

}
