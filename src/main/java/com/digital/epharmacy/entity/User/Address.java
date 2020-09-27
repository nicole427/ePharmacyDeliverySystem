package com.digital.epharmacy.entity.User;



/*
 * Author: Nicole Hawthorne
 * Desc: Address Entity composed of User Profile and Pharmacy entity that stores the user and pharmacy address/location
 * Date: 03/07/2020
 * */
//main class
public class Address {
    //naming entity attributes and assigning their variable values
    private String pharmacyId;
    private int streetNumber, areaCode;
    private String streetName, areaName;
    private String userId;

    // Added default constructor for SpringBoot implementation.
    public Address(){

    }
    //constructor for Builder class
    private Address (Builder builder){
        this.userId = builder.userId;
        this.pharmacyId = builder.pharmacyId;
        this.streetNumber = builder.streetNumber;
        this.areaCode = builder.areaCode;
        this.streetName = builder.streetName;
        this.areaName = builder.areaName;
    }

    //getters to get all values of attributes
    public String getUserId() {
        return userId;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    // toString to display what is in the Address class
    @Override
    public String toString() {
        return "Address{" +
                "userId=" + userId +
                ", pharmacyId=" + pharmacyId +
                ", streetNumber=" + streetNumber +
                ", areaCode=" + areaCode +
                ", streetName='" + streetName + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder {
        private String pharmacyId;
        private int streetNumber, areaCode;
        private String streetName, areaName;
        private String userId;

        //setting UserId value using builder pattern
        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }
        //setting PharmacyId value using builder pattern
        public Builder setPharmacyId(String pharmacyId){
            this.pharmacyId = pharmacyId;
            return this;
        }
        //setting StreetNumber value using builder pattern
        public Builder setStreetNumber(int streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }
        //setting AreaCode value using builder pattern
        public Builder setAreaCode(int areaCode){
            this.areaCode = areaCode;
            return this;
        }
        //setting StreetName value using builder pattern
        public Builder setStreetName(String streetName){
            this.streetName = streetName;
            return this;
        }

        //setting AreaName value using builder pattern
        public Builder setAreaName(String areaName){
            this.areaName = areaName;
            return this;
        }
        // Builder copy method that create instance of ContactInformation and makes a copy out of it
        public Builder copy(Address address){
            this.userId = address.userId;
            this.pharmacyId = address.pharmacyId;
            this.streetNumber = address.streetNumber;
            this.areaCode = address.areaCode;
            this.streetName = address.streetName;
            this.areaName = address.areaName;
            return this;
        }

        //creating and instance of this class
        public Address build(){
            return new Address(this);
        }
    }
}
