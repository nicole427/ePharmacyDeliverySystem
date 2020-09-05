package com.digital.epharmacy.service.PrescriptionItem;

/*
 * Author: Nelson Mpyana
 * Date: 02/09/2020
 * Desc: Interface to implement the Prescription Item methods
 * */

import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface PrescriptionItemService extends IService<PrescriptionItem, String> {
    Set<PrescriptionItem> getAll();
}
