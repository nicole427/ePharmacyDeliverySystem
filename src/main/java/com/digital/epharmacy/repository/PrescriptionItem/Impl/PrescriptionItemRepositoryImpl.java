///*
// * Author: Matsobane Nelson Mpyana
//<<<<<<< HEAD
// * Desc: PrescriptionItemRepository impl
//=======
// * Desc: PrescriptionItemRepository Impl
//>>>>>>> upstream/groupCollaboration
// * Date: 30 August 2020
// */
//package com.digital.epharmacy.repository.PrescriptionItem.Impl;
//
//import com.digital.epharmacy.entity.Catalogue.CatalogueItem;
//import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;;
//import com.digital.epharmacy.repository.CatalogueItem.CatalogueItemRepository;
////import com.digital.epharmacy.repository.CatalogueItem.Impl.CatalogueItemRepositoryImpl;
//import com.digital.epharmacy.repository.PrescriptionItem.PrescriptionItemRepository;;
//import com.digital.epharmacy.repository.PrescriptionItem.Impl.PrescriptionItemRepositoryImpl;
//
//import java.util.Set;
//import java.util.HashSet;
//public class PrescriptionItemRepositoryImpl implements  PrescriptionItemRepository {
//
//    private static PrescriptionItemRepository repository = null;
//    private Set<PrescriptionItem> PrescriptionItemDB;
//
//    public PrescriptionItemRepositoryImpl()
//    {
//        this.PrescriptionItemDB = new HashSet<>();
//    }
//    public static PrescriptionItemRepository getRepository(){
//        if (repository == null) repository = new PrescriptionItemRepositoryImpl();
//        return repository;
//    }
//    @Override
//    public Set<PrescriptionItem> getAll() {
//        return null;
//    }
//
//    @Override
//    public PrescriptionItem create(PrescriptionItem prescriptionItem) {
//        this.PrescriptionItemDB.add(prescriptionItem);
//        return prescriptionItem;
//    }
//
//    @Override
//    public PrescriptionItem read(String s) {
//        PrescriptionItem name = null;
//        for (PrescriptionItem item: this.PrescriptionItemDB)
//            if(item.getPrescribingDoctor().equalsIgnoreCase(s)) {
//                name = item;
//            }
//        return name;
//    }
//
//    @Override
//    public PrescriptionItem update(PrescriptionItem prescriptionItem) {
//        try {
//            PrescriptionItem oldPrescriptionItem = read(prescriptionItem.getPrescribingDoctor());
//            if(oldPrescriptionItem != null){
//                this.PrescriptionItemDB.remove(oldPrescriptionItem);
//                this.PrescriptionItemDB.add(prescriptionItem);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return prescriptionItem;
//    }
//
//    @Override
//    public boolean delete(String s) {
//        PrescriptionItem prescriptionItem = null;
//        try {
//            prescriptionItem = read(s);
//            if (s != null)
//            {
//                this.PrescriptionItemDB.remove(prescriptionItem);
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//}
