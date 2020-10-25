package com.digital.epharmacy.service.Pharmacy;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.service.IService;
/*
 * Author: Opatile Kelobang
 * Desc: MedicalAid Service implementation test
 * Date: 02 September 2020
 */
import java.util.Set;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy service
 * Date: 03 September 2020
 *
 * Modified: 26 October 2020
 * Added Read By Name Method
 */
public interface PharmacyService extends IService<Pharmacy, String> {
    Set<Pharmacy> getAll();
    Pharmacy findPharmacyByPharmacyName(String pharmacyName);
}
