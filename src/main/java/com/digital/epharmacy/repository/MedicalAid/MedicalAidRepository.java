package com.digital.epharmacy.repository.MedicalAid;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.repository.Repository;


import java.util.Set;

/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid repository
 * Date: 29 August 2020
 */
public interface MedicalAidRepository extends Repository<MedicalAid, String> {
    Set<MedicalAid> getAll();
}
