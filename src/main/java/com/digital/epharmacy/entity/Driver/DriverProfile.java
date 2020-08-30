package com.digital.epharmacy.entity.Driver;
/*
    Author: Chad Boswell
    Desc: DriverProfile entity composed DriverProfile and DriverCar that stores details of the Driver and car
    Date: 4 July 2020
 */
public class DriverProfile {

    private String driverId;
    private String driverName, driverSurname, driverLocation;

    // builder pattern method constructor
    private DriverProfile(Builder builder){
        this.driverId = builder.driverId;
        this.driverName = builder.driverName;
        this.driverSurname = builder.driverSurname;
        this.driverLocation = builder.driverLocation;
    }
    // getters for all attributes of entity DriverProfile
    public String getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public String getDriverLocation() {
        return driverLocation;
    }
    // to string to display what is in the class
    @Override
    public String toString() {
        return "DriverProfile{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverSurname='" + driverSurname + '\'' +
                ", driverLocation='" + driverLocation + '\'' +
                '}';
    }
    // add setters using building pattern
    public static class Builder{

        private String driverId;
        private String driverName, driverSurname, driverLocation;

        public Builder setDriverId(String driverId){
            this.driverId = driverId;
            return this;
        }
        public Builder setDriverName(String driverName){
            this.driverName= driverName;
            return this;
        }
        public Builder setDriverSurname(String driverSurname){
            this.driverSurname = driverSurname;
            return this;
        }
        public Builder setDriverLocation(String driverLocation){
            this.driverLocation= driverLocation;
            return this;
        }

        //to below method is to make another copy of driverProfile
        public Builder copy (DriverProfile driverProfile){
            this.driverId = driverProfile.driverId;
            this.driverName = driverProfile.driverName;
            this.driverSurname = driverProfile.driverSurname;
            this.driverLocation = driverProfile.driverLocation;
            return this;
        }
        // creating an instance for the builder pattern
        public DriverProfile builder(){
            return new DriverProfile(this);
        }
    }
}
