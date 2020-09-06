package com.digital.epharmacy.service.CatalogueItem.impl;

/*
 * Author: Nelson Mpyana
 * Desc: CatalogueItemServiceImpl
 * Date: 3 September 2020
 */
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.repository.CatalogueItem.CatalogueItemRepository;
import com.digital.epharmacy.repository.CatalogueItem.Impl.CatalogueItemRepositoryImpl;
import com.digital.epharmacy.service.CatalogueItem.CatalogueItemService;

import java.util.Set;
import java.util.stream.Collectors;

public class CatalogueItemServiceImpl implements CatalogueItemService {
    private static CatalogueItemService service = null;
    private CatalogueItemRepository repository;

    private  CatalogueItemServiceImpl() {
        this.repository = CatalogueItemRepositoryImpl.getRepository();
    }

    public static CatalogueItemService getService() {
        if (service == null) service = new CatalogueItemServiceImpl();
        return service;
    }

    @Override
    public Set<CatalogueItem> getAll() {
        return this.repository.getAll();
    }


    @Override
    public CatalogueItem create(CatalogueItem catalogueItem) {
        return this.repository.create(catalogueItem);
    }

    @Override
    public CatalogueItem read(String catalogueItem) {
        return this.repository.read(catalogueItem);
    }



    @Override
    public CatalogueItem update(CatalogueItem catalogueItem) {
        return this.repository.update(catalogueItem);
    }

    @Override
    public boolean delete(String catalogueItem) {
        return this.repository.delete(catalogueItem);
    }
}
