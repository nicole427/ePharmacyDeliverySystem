package com.digital.epharmacy.entity;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy entity store pharmacy id and pharmacy name
 * Date: 04 July 2020
 */


public class Pharmacy {
    // all the attributes of entity
    private int pharmacyID;
    private String pharmacyName;

    // builder pattern method constructor
    private Pharmacy(Builder builder)
    {
        this.pharmacyID = builder.pharmacyID;
        this.pharmacyName = builder.pharmacyName;
    }

    // getters for all attributes of entity Pharmacy
    public int getPharmacyID() {
        return pharmacyID;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    // to string method for Pharmacy entity
    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyID=" + pharmacyID +
                ", pharmacyName='" + pharmacyName + '\'' +
                '}';
    }

    // add setters using building pattern
    public static class Builder
    {
        private int pharmacyID;
        private String pharmacyName;

        public Builder setPharmacyID(int pharmacyID) {
            this.pharmacyID = pharmacyID;
            return this;
        }

        public Builder setPharmacyName(String pharmacyName) {
            this.pharmacyName = pharmacyName;
            return this;
        }

        // Copy method for Pharmacy entity
        public Builder copy (Pharmacy pharmacy)
        {
            this.pharmacyID = pharmacy.pharmacyID;
            this.pharmacyName = pharmacy.pharmacyName;
            return this;
        }

        // Instance for Builder Pattern
        public Pharmacy builder() {
            return new Pharmacy(this);
        }
    }
}

