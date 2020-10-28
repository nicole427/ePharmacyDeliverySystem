package com.digital.epharmacy.service.Driver.impl;
 /*
 * Author: Chad Boswell 215254589
 * Date: 04/09/2020
 * Desc: Implementation for all DriverProfile methods
 *
 * Modified: 27 October 2020
 * Removed Singleton Implementation and autowired JPA Repository
 * Fixed method to use JPA
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.repository.Driver.DriverProfileRepository;
import com.digital.epharmacy.service.Driver.DriverProfileService;
import org.springframework.stereotype.Service;
import com.digital.epharmacy.controller.ExceptionHandler.MyCustomExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DriverProfileServiceImpl implements DriverProfileService {

    @Autowired
    private DriverProfileRepository repository;

    @Override
    public Set<DriverProfile> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public DriverProfile create(DriverProfile driverProfile) {

        try {
                return this.repository.save(driverProfile);
            }catch (Exception e)
            {
                throw new MyCustomExceptionHandler("Driver Profile '" + driverProfile.getDriverId() + "' already exists");
            }
    }

    @Override
    public DriverProfile read(String s) {

        DriverProfile newDriverProfile= repository.findById(s).orElseGet(null);

        if (newDriverProfile == null)
            throw new MyCustomExceptionHandler("Driver Profile or id does not exist");

        return newDriverProfile;
    }

    @Override
    public DriverProfile update(DriverProfile driverProfile) {

        if(this.repository.existsById(driverProfile.getDriverId())) {
            return this.repository.save(driverProfile);
        }
        else {
            throw new MyCustomExceptionHandler("Driver Profile does not exist.");
        }

    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)){
            return false;
        } else {
            return true;
        }
    }
}
