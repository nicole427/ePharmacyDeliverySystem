/*
 * Author: Matsobane Nelson Mpyana
 * Desc: CatalogueItemRepository
 * Date: 04 September 2020
 */


package com.digital.epharmacy.repository.PrescriptionItem;

import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

public interface PrescriptionItemRepository  extends Repository<PrescriptionItem, String> {
    Set<PrescriptionItem> getAll();
}
