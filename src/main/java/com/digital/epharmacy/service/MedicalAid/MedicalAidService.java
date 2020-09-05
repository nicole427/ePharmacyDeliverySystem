package com.digital.epharmacy.service.MedicalAid;

import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.service.IService;

import java.util.Set;
/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid service
 * Date: 02 September 2020
 */
public interface MedicalAidService extends IService<MedicalAid, String> {
    Set<MedicalAid> getAll();
}
