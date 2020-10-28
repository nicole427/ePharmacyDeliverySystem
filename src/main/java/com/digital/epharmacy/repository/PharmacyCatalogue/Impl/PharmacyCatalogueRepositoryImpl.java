///*
// * Author: Matsobane Nelson Mpyana
//<<<<<<< HEAD
// * Desc: PharmacyCatalogueRepository impl
//=======
// * Desc: PharmacyCatalogueRepository Impl
//>>>>>>> upstream/groupCollaboration
// * Date: 29 August 2020
// */
//package com.digital.epharmacy.repository.PharmacyCatalogue.Impl;
//
//import com.digital.epharmacy.entity.Catalogue.PharmacyCatalogue;
//import com.digital.epharmacy.repository.PharmacyCatalogue.PharmacyCatalogueRepository;
//
//import java.util.Set;
//import java.util.HashSet;
//
//public class PharmacyCatalogueRepositoryImpl implements PharmacyCatalogueRepository {
//    private static PharmacyCatalogueRepository repository = null;
//    private Set<PharmacyCatalogue> pharmacyCatalogueDB;
//
//    public PharmacyCatalogueRepositoryImpl()
//    {
//        this.pharmacyCatalogueDB = new HashSet<>();
//    }
//
//    public static PharmacyCatalogueRepository getRepository(){
//        if (repository == null) repository = new PharmacyCatalogueRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public PharmacyCatalogue create(PharmacyCatalogue pharmacyCatalogue) {
//       this.pharmacyCatalogueDB.add(pharmacyCatalogue);
//       return pharmacyCatalogue;
//    }
//
//    @Override
//    public PharmacyCatalogue read(String pharmacyID) {
//        PharmacyCatalogue name = null;
//        for (PharmacyCatalogue u: this.pharmacyCatalogueDB)
//            if(u.getPharmacyId().equalsIgnoreCase(pharmacyID)) {
//                name = u;
//            }
//        return name;
//    }
//
//    @Override
//    public PharmacyCatalogue update (PharmacyCatalogue pharmacyCatalogue) {
//        PharmacyCatalogue oldPharmacy = read(pharmacyCatalogue.getPharmacyId());
//        if(oldPharmacy != null){
//            this.pharmacyCatalogueDB.remove(oldPharmacy);
//            this.pharmacyCatalogueDB.add(pharmacyCatalogue);
//        }
//        return pharmacyCatalogue;
//    }
//
//    @Override
//    public boolean delete(String pharmacyID) {
//        PharmacyCatalogue pharmacyCatalogue = read(pharmacyID);
//        if (pharmacyID != null){
//            this.pharmacyCatalogueDB.remove(pharmacyCatalogue);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<PharmacyCatalogue> getAll() {
//        return this.pharmacyCatalogueDB;
//    }
//}
