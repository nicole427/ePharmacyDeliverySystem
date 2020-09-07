package com.digital.epharmacy.service.CatalogueItem;


import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.service.IService;

import java.util.Set;

/*
 * Author: Nelson Mpyana
 * Desc: CatalogueItem Service
 * Date: 3 September 2020
 */
public interface CatalogueItemService extends IService<CatalogueItem, String> {
    Set<CatalogueItem> getAll();


}
