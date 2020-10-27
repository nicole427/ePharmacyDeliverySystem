//package com.digital.epharmacy.repository.CatalogueItem.Impl;
///*
// * Author: Matsobane Nelson Mpyana
//<<<<<<< HEAD
// * Desc: CatalogueItemRepository impl
//=======
// * Desc: CatalogueItemRepository Impl
//>>>>>>> upstream/groupCollaboration
// * Date: 30 August 2020
// */
//
//import com.digital.epharmacy.repository.CatalogueItem.CatalogueItemRepository;
//import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
//
//import java.util.Set;
//import java.util.HashSet;
//
//@Deprecated
//public class CatalogueItemRepositoryImpl implements CatalogueItemRepository {
//
//    private static CatalogueItemRepository repository = null;
//    private Set<CatalogueItem> CatalogueItemDB;
//
//    public CatalogueItemRepositoryImpl()
//    {
//        this.CatalogueItemDB = new HashSet<>();
//    }
//    public static CatalogueItemRepository getRepository(){
//        if (repository == null) repository = new CatalogueItemRepositoryImpl();
//        return repository;
//    }
//
//
//    @Override
//    public CatalogueItem create(CatalogueItem catalogueItem) {
//        this.CatalogueItemDB.add(catalogueItem);
//        return catalogueItem;
//    }
//
//    @Override
//    public CatalogueItem read(String itemNumber)  {
//        CatalogueItem name = null;
//        for (CatalogueItem item: this.CatalogueItemDB)
//            if(item.getItemName().equalsIgnoreCase(itemNumber)) {
//                name = item;
//
//            }
//        return name;
//    }
//
//    @Override
//    public CatalogueItem update(CatalogueItem catalogueItem) {
//        try {
//            CatalogueItem oldCatalogueItem = read(catalogueItem.getItemName());
//            if(oldCatalogueItem != null){
//                this.CatalogueItemDB.remove(oldCatalogueItem);
//                this.CatalogueItemDB.add(catalogueItem);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return catalogueItem;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        CatalogueItem catalogueItem = null;
//        try {
//
//            catalogueItem = read(s);
//            if (s != null)
//            {
//                this.CatalogueItemDB.remove(catalogueItem);
//                return true;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//    @Override
//    public Set<CatalogueItem> getAll() {
//        return null;
//    }
//}
