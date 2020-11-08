package com.digital.epharmacy.controller.Driver;
/*
 * Author: Chad Boswell 215254589
 * Date: 25/09/2020
 * Desc: Controller of Driver Car
 */
import com.digital.epharmacy.entity.Driver.DriverCar;
import com.digital.epharmacy.factory.Driver.DriverCarFactory;
import com.digital.epharmacy.service.Driver.impl.DriverCarServiceImpl;
import com.digital.epharmacy.service.Validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/car")
public class DriverCarController {

    @Autowired
    private DriverCarServiceImpl carService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/create")
    public ResponseEntity<DriverCar> create(@Valid @RequestBody DriverCar driverCar, BindingResult result) {

        ResponseEntity<DriverCar> errorMap = (ResponseEntity<DriverCar>) validationService.MapValidationService(result);

        if (errorMap != null)
            return errorMap;

        DriverCar newDriverCar = DriverCarFactory
                .createDriverCar(
                        driverCar.getCarRegistration(),
                        driverCar.getCarColour(),
                        driverCar.getCarName(),
                        driverCar.getCarModel()
                );

       carService.create(newDriverCar);

       return new ResponseEntity<DriverCar>(driverCar, HttpStatus.CREATED);
    }

    @GetMapping("/read/{driverId}")
    public DriverCar read(@PathVariable String driverId){
        return carService.read(driverId);
    }

    @PostMapping("/update")
    public DriverCar update(@RequestBody DriverCar driverId){
        return carService.update(driverId);
    }

    @GetMapping("/all")
    public Set<DriverCar>getAll(){
        return carService.getAll();
    }

    @DeleteMapping("/delete/{driverId}")
    public boolean delete(@PathVariable String driverId){
        return carService.delete(driverId);
    }
}
