package com.digital.epharmacy.service.Driver.impl;
 /*
 * Author: Chad Boswell 215254589
 * Desc: Driver Car Service implementation gives access to repository
 * Date: 04 September 2020
 *
 * Modified: 27 October 2020
 * Removed Singleton Implementation and autowired JPA Repository
 * Fixed method to use JPA
 */

import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.repository.Driver.DriverCarRepository;
import com.digital.epharmacy.service.Driver.DriverCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DriverCarServiceImpl implements DriverCarService {

    @Autowired
    private DriverCarRepository repository;

    @Override
    public Set<DriverCar> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public DriverCar create(DriverCar driverCar) {
        try{
            return this.repository.save(driverCar);
        } catch (Exception e){
            throw new MyCustomExceptionHandler("Driver Car '" + driverCar.getCarId()+ "' already exists");
        }
    }

    @Override
    public DriverCar read(String driverCar) {

        DriverCar newDriverCar = repository.findById(driverCar).orElseGet(null);

        if(newDriverCar == null)
            throw new MyCustomExceptionHandler("Driver car or id does not exist");

        return newDriverCar;
    }

    @Override
    public DriverCar update(DriverCar driverCar) {

        if (this.repository.existsById(driverCar.getCarId())) {
            return this.repository.save(driverCar);
        }
        else {
            throw new MyCustomExceptionHandler("Driver car does not exist.");
        }

    }

    @Override
    public boolean delete(String driverCar) {

        this.repository.deleteById(driverCar);
        if (this.repository.existsById(driverCar)){
            throw new MyCustomExceptionHandler("Entry not deleted");
        } else {
            return true;
        }
    }
}
