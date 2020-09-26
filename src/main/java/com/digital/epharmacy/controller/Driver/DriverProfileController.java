package com.digital.epharmacy.controller.Driver;
/*
 * Author: Chad Boswell 215254589
 * Date: 25/09/2020
 * Desc: Controller of Driver profile
 */
import com.digital.epharmacy.entity.Driver.DriverProfile;
import com.digital.epharmacy.factory.Driver.DriverProfileFactory;
import com.digital.epharmacy.service.Driver.impl.DriverProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping ("/driver")
public class DriverProfileController {
    @Autowired
    private DriverProfileServiceImpl driverProfileService;

    @PostMapping ("/create")
    public DriverProfile create (@RequestBody DriverProfile driverProfile){
        DriverProfile newDriverProfile = DriverProfileFactory.createDriverProfile(driverProfile.getDriverName(),driverProfile.getDriverSurname(),driverProfile.getDriverLocation());
        return driverProfileService.create(newDriverProfile);
    }
    @GetMapping ("/read/{driverId}")
    public DriverProfile read (@PathVariable String driverId){
        return driverProfileService.read(driverId);
    }
    @PostMapping ("/update")
    public DriverProfile update (@RequestBody DriverProfile driverProfile){
        return driverProfileService.update(driverProfile);
    }

    @GetMapping("/all")
    public Set<DriverProfile>getAll(){
        return driverProfileService.getAll();
    }
    @DeleteMapping ("/delete/{driverId}")
    public boolean delete(@PathVariable String driverId){
        return driverProfileService.delete(driverId);
    }
}
