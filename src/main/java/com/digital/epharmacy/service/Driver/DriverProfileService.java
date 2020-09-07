package com.digital.epharmacy.service.Driver;
 /*
 * Author: Chad Boswell 215254589
 * Date: 04/09/2020
 * Desc: DriverProfile Service interface that extends the main interface.
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.service.IService;

import java.util.Set;

public interface DriverProfileService extends IService <DriverProfile , String> {
    Set<DriverProfile> getAll();
}
