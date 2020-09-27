package com.digital.epharmacy.service.Driver.impl;
 /*
 * Author: Chad Boswell 215254589
 * Date: 04/09/2020
 * Desc: Implementation for all DriverProfile methods
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.repository.Driver.DriverProfileRepository;
import com.digital.epharmacy.repository.Driver.impl.DriverProfileRepositoryImpl;
import com.digital.epharmacy.service.Driver.DriverProfileService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class DriverProfileServiceImpl implements DriverProfileService {

    private static DriverProfileService service = null;
    private DriverProfileRepository repository;

    private DriverProfileServiceImpl() {
        this.repository = DriverProfileRepositoryImpl.getRepository();
    }

    public static DriverProfileService getService(){
        if(service == null)
            service = new DriverProfileServiceImpl();
        return  service;
    }

    @Override
    public Set<DriverProfile> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DriverProfile create(DriverProfile driverProfile) {
        return this.repository.create(driverProfile);
    }

    @Override
    public DriverProfile read(String s) {
        return this.repository.read(s);
    }

    @Override
    public DriverProfile update(DriverProfile driverProfile) {
        return this.repository.update(driverProfile);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
