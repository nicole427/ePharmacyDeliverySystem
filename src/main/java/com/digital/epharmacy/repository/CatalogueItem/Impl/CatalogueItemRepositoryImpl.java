package com.digital.epharmacy.repository.CatalogueItem.Impl;
/*
 * Author: Matsobane Nelson Mpyana
 * Desc: CatalogueItemRepository impl
 * Date: 30 August 2020
 */

import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
import com.digital.epharmacy.entity.Order.Order;
import com.digital.epharmacy.entity.Pharmacy.Pharmacy;
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.repository.CatalogueItem.CatalogueItemRepository;
import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
import com.digital.epharmacy.repository.PharmacyCatalogue.Impl.PharmacyCatalogueRepositoryImpl;
import com.digital.epharmacy.repository.PharmacyCatalogue.PharmacyCatalogueRepository;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class CatalogueItemRepositoryImpl implements CatalogueItemRepository {

    private static CatalogueItemRepository repository = null;
    private Set<CatalogueItem> CatalogueItemDB;

    public CatalogueItemRepositoryImpl()
    {
        this.CatalogueItemDB = new HashSet<>();
    }
    public static CatalogueItemRepository getRepository(){
        if (repository == null) repository = new CatalogueItemRepositoryImpl();
        return repository;
    }


    @Override
    public CatalogueItem create(CatalogueItem catalogueItem) {
        this.CatalogueItemDB.add(catalogueItem);
        return catalogueItem;
    }

    @Override
    public CatalogueItem read(String itemNumber)  {
        CatalogueItem name = null;
        for (CatalogueItem item: this.CatalogueItemDB)
            if(item.getItemName().equalsIgnoreCase(itemNumber)) {
                name = item;

            }
        return name;
    }

    @Override
    public CatalogueItem update(CatalogueItem catalogueItem) {
        try {
            CatalogueItem oldCatalogueItem = read(catalogueItem.getItemName());
            if(oldCatalogueItem != null){
                this.CatalogueItemDB.remove(oldCatalogueItem);
                this.CatalogueItemDB.add(catalogueItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catalogueItem;
    }

    @Override
    public boolean delete(String s) {
        CatalogueItem catalogueItem = null;
        try {

            catalogueItem = read(s);
            if (s != null)
            {
                this.CatalogueItemDB.remove(catalogueItem);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Set<Pharmacy> getAll() {
        return null;
    }
}
