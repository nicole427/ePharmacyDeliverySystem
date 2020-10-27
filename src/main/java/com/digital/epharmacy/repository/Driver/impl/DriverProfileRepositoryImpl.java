//package com.digital.epharmacy.repository.Driver.impl;
///*
// Author: Chad Boswell 215254589
// * Date: 29/08/2020
// * Description: Driver Repository to create, delete and update a driver profile
// *
// * Modified: 27 October 2020
// * commented out repository
//*/
//import com.digital.epharmacy.repository.Driver.DriverProfileRepository;
//import com.digital.epharmacy.entity.Driver.DriverProfile;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//public class DriverProfileRepositoryImpl implements DriverProfileRepository {
//    private static DriverProfileRepository repository = null;
//    private Set<DriverProfile> driverProfileDB;
//
//    public DriverProfileRepositoryImpl() {
//        this.driverProfileDB = new HashSet<>();
//    }
//
//    public static DriverProfileRepository getRepository(){
//        if(repository == null)
//            repository = new DriverProfileRepositoryImpl();
//        return repository;
//    }
//    @Override
//    public DriverProfile create (DriverProfile driverProfile){
//        this.driverProfileDB.add(driverProfile);
//        return driverProfile;
//    }
//    @Override
//    public DriverProfile read (String driverId){
//        DriverProfile driverProfile = null;
//        for (DriverProfile u: this.driverProfileDB)
//            if (u.getDriverId().equalsIgnoreCase(driverId) ) {
//                driverProfile = u;
//                break;
//            }
//        return driverProfile;
//    }
//    @Override
//    public DriverProfile update (DriverProfile driverProfile){
//        DriverProfile oldDriverProfile = read(driverProfile.getDriverId());
//        if (oldDriverProfile != null ){
//            this.driverProfileDB.remove(oldDriverProfile);
//            this.driverProfileDB.add(driverProfile);
//
//        }
//        return driverProfile;
//    }
//    @Override
//    public boolean delete (String driverId){
//        DriverProfile driverProfile = read(driverId);
//        if (driverId != null ){
//            this.driverProfileDB.remove(driverProfile);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<DriverProfile> getAll() {
//        return this.driverProfileDB;
//    }
//}