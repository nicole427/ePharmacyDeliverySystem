/*
 * Author: Matsobane Nelson Mpyana
 * Desc: CatalogueItemRepository
 * Date: 30 August 2020
 */


package com.digital.epharmacy.repository.CatalogueItem;

import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

public interface CatalogueItemRepository  extends Repository<CatalogueItem, String> {
    Set<CatalogueItem> getAll();
}
