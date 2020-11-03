package com.digital.epharmacy.entity.Driver;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;


/*
    Author: Chad Boswell
<<<<<<< HEAD
    Desc: DriverProfile entity composed DriverProfile and DriverCar that stores details of the Driver and car
=======
    Desc: Driver entity composed Driver and DriverCar that stores details of the Driver and car
>>>>>>> origin/groupCollaboration
    Date: 4 July 2020

    Update: 27/10/20
    Modified: added noBlank validation and created a composite relation between driver profile and car and hash set
              one to one relationship
 */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key
 and changed default constructor to protected
 * Date: 25/10/2020
 * */

@Entity
public class DriverProfile {

    @Id
    @Column(name= "id")
    private String driverId;
    @NotBlank(message = "Driver Name is required")
    private String driverName;
    @NotBlank(message = "Driver Surname is required")
    private String driverSurname;
    @NotBlank(message = "Driver location is required")
    private String driverLocation;



    protected DriverProfile() {}

    // builder pattern method constructor
    private DriverProfile(Builder builder){
        this.driverId = builder.driverId;
        this.driverName = builder.driverName;
        this.driverSurname = builder.driverSurname;
        this.driverLocation = builder.driverLocation;
    }
// HEAD
    // getters for all attributes of entity DriverProfile

    // getters for all attributes of entity Driver
// origin/groupCollaboration
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
        // return "DriverProfile{" +

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverProfile driverProfile = (DriverProfile) o;
        return driverId.equals(driverProfile.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId);
    }
}
