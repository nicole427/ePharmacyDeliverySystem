package com.digital.epharmacy.entity;
/*
    Author: Chad
    Desc: DriverCar stores driverId using composition with DriverProfile
    Date: 4 July 2020
 */
public class DriverCar {
    // all the attributes of entity
    private String driverId;
    private String carRegistration;
    private String carColour, carName, carModel;

    // builder pattern method constructor
    private DriverCar(Builder builder){
        this.driverId = builder.driverId;
        this.carRegistration = builder.carRegistration;
        this.carColour = builder.carColour;
        this.carName = builder.carName;
        this.carModel = builder.carModel;
    }

    // getters for all attributes of entity DriverCar
    public String getDriverId() {
        return driverId;
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
                "driverId=" + driverId +
                ", carRegistration=" + carRegistration +
                ", carColour='" + carColour +
                ", carName=" + carName +
                ", carModel=" + carModel +'\''  +
                '}';
    }

    // add setters using building pattern
    public static class Builder{

        private String driverId;
            private String carRegistration;
        private String carColour, carName, carModel;

        public Builder setDriverId(String driverId){
            this.driverId = driverId;
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
            this.driverId = driverCar.driverId;
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
}
