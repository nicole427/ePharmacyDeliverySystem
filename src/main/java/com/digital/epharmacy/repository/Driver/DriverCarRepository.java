package com.digital.epharmacy.repository.Driver;
/*
 * Author: Chad Boswell
 * Date: 29/08/2020
 * Description: Driver Repository class extends the IRepository class
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.repository.Repository;

import java.util.Set;

public interface DriverCarRepository extends Repository<DriverCar, String> {
    Set<DriverCar> getAll();
}

