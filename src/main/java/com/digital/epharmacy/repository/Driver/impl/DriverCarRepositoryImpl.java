//package com.digital.epharmacy.repository.Driver.impl;
/// * Author: Chad Boswell
// * Desc: Driver Car implementation
// * Date: 30 August 2020
//
//import com.digital.epharmacy.entity.Driver.DriverCar;
//import com.digital.epharmacy.repository.Driver.DriverCarRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class DriverCarRepositoryImpl implements DriverCarRepository {
//    private static DriverCarRepository repository = null;
//    private Set<DriverCar> driverCarDB;
//
//    public DriverCarRepositoryImpl()
//    {
//        this.driverCarDB = new HashSet<>();
//    }
//
//    public static DriverCarRepository getRepository(){
//        if (repository == null) repository = new com.digital.epharmacy.repository.Driver.impl.DriverCarRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public DriverCar create(DriverCar driverCar) {
//        this.driverCarDB.add(driverCar);
//        return driverCar;
//    }
//
//    @Override
//    public DriverCar read(String driverID) {
//        DriverCar name = null;
//        for (DriverCar u: this.driverCarDB)
//            if(u.getDriverId().equalsIgnoreCase(driverID)) {
//                name = u;
//            }
//        return name;
//    }
//
//    @Override
//    public DriverCar update(DriverCar driverCar) {
//        DriverCar oldDriverCar = read(driverCar.getDriverId());
//        if(oldDriverCar != null){
//            this.driverCarDB.remove(oldDriverCar);
//            this.driverCarDB.add(driverCar);
//        }
//        return driverCar;
//    }
//
//    @Override
//    public boolean delete(String driverID) {
//        DriverCar driverCar = read(driverID);
//        if (driverID != null){
//            this.driverCarDB.remove(driverCar);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<DriverCar> getAll() {
//        return this.driverCarDB;
//    }
//}