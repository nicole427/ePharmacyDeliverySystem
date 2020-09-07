package com.digital.epharmacy.service.Driver;
 /*
 * Author: Chad Boswell 215254589
 * Desc: Driver car Service implementation test
 * Date: 04 September 2020
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface DriverCarService extends IService<DriverCar, String> {
    Set<DriverCar> getAll();
}
