package com.digital.epharmacy.entity.Driver;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/*
    Author: Chad
<<<<<<< HEAD
    Desc: DriverCar stores carId using composition with DriverProfile
=======
    Desc: DriverCar stores carId using composition with Driver
>>>>>>> origin/groupCollaboration
    Date: 4 July 2020

    Modified: added noBlank validation and created a composite relation between driver profile and car and hash set
    Date: 27/10/20
 */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key
 and changed default constructor to protected
 * Date: 25/10/2020
 * */

@Entity
@Table(name = "car")
public class DriverCar {

    // all the attributes of entity
    @Id
    @Column(name = "id")
    private String carId;
    @NotBlank(message = "Car Registration is required")
    private String carRegistration;
    @NotBlank(message = "Car Colour is required")
    private String carColour;
    @NotBlank(message = "Car name is required")
    private String carName;
    @NotBlank(message = "Car Model is required")
    private String carModel;

    protected DriverCar (){}

    // builder pattern method constructor
    private DriverCar(Builder builder){
        this.carId = builder.carId;
        this.carRegistration = builder.carRegistration;
        this.carColour = builder.carColour;
        this.carName = builder.carName;
        this.carModel = builder.carModel;
    }

    // getters for all attributes of entity DriverCar
    public String getCarId() {
        return carId;
    }

    public String getCarRegistration() {
        return carRegistration;
    }

    public String getCarColour() {
        return carColour;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarModel() {
        return carModel;
    }

    // to string to display what is in the class
    @Override
    public String toString() {
        return "DriverCar{" +
                "carId=" + carId +
                ", carRegistration=" + carRegistration +
                ", carColour='" + carColour +
                ", carName=" + carName +
                ", carModel=" + carModel +'\''  +
                '}';
    }

    // add setters using building pattern
    public static class Builder{

        private String carId;
        private String carRegistration;
        private String carColour, carName, carModel;

        public Builder setCarId(String carId){
            this.carId = carId;
            return this;
        }

        public Builder setCarRegistration(String carRegistration){
            this.carRegistration = carRegistration;
            return this;
        }

        public Builder setCarColour(String carColour){
            this.carColour= carColour;
            return this;
        }

        public Builder setCarName(String carName){
            this.carName= carName;
            return this;
        }

        public Builder setCarModel(String carModel){
            this.carModel= carModel;
            return this;
        }

        //to below method is to make another copy of DriverCar
        public Builder copy (DriverCar driverCar){
            this.carId = driverCar.carId;
            this.carRegistration = driverCar.carRegistration;
            this.carColour = driverCar.carColour;
            this.carName = driverCar.carName;
            this.carModel = driverCar.carModel;
            return this;
        }

        // creating an instance for the builder pattern
        public DriverCar builder(){
            return new DriverCar(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverCar that = (DriverCar) o;
        return carId.equals(that.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }
}
