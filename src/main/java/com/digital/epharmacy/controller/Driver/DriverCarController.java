package com.digital.epharmacy.controller.Driver;
/*
 * Author: Chad Boswell 215254589
 * Date: 25/09/2020
 * Desc: Controller of Driver Car
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.factory.Driver.DriverCarFactory;
import com.digital.epharmacy.service.Driver.impl.DriverCarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/car")
public class DriverCarController {

    @Autowired
    private DriverCarServiceImpl carService;

    @PostMapping("/create")
    public DriverCar create(@RequestBody DriverCar driverCar) {
        DriverCar newDriverCar = DriverCarFactory.createDriverCar(driverCar.getCarColour(),driverCar.getCarModel(),driverCar.getCarName(),driverCar.getCarRegistration(),driverCar.getCarId());
        return carService.create(newDriverCar);
    }

    @GetMapping("/read/{carId}")
    public DriverCar read(@PathVariable String carId){
        return carService.read(carId);
    }

    @PostMapping("/update")
    public DriverCar update(@RequestBody DriverCar carId){
        return carService.update(carId);
    }

    @GetMapping("/all")
    public Set<DriverCar>getAll(){
        return carService.getAll();
    }

    @DeleteMapping("/delete/{carId}")
    public boolean delete(@PathVariable String carId){
        return carService.delete(carId);
    }
}
