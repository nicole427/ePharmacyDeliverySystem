package com.digital.epharmacy.service.Driver.impl;
 /*
 * Author: Chad Boswell 215254589
 * Desc: Driver Car Service implementation gives access to repository
 * Date: 04 September 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.repository.Driver.impl.DriverCarRepositoryImpl;
import com.digital.epharmacy.repository.Driver.DriverCarRepository;
import com.digital.epharmacy.service.Driver.DriverCarService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class DriverCarServiceImpl implements DriverCarService {

    public static DriverCarService service = null;
    private DriverCarRepository repository;

    private DriverCarServiceImpl(){
        this.repository = DriverCarRepositoryImpl.getRepository();
    }

    public static DriverCarService getService(){
        if(service == null) service = new com.digital.epharmacy.service.Driver.impl.DriverCarServiceImpl();
        return service;
    }

    @Override
    public Set<DriverCar> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DriverCar create(DriverCar driverCar) {
        return this.repository.create(driverCar);
    }

    @Override
    public DriverCar read(String driverCar) {
        return this.repository.read(driverCar);
    }

    @Override
    public DriverCar update(DriverCar driverCar) {
        return this.repository.update(driverCar);
    }

    @Override
    public boolean delete(String driverCar) {
        return this.repository.delete(driverCar);
    }
}
