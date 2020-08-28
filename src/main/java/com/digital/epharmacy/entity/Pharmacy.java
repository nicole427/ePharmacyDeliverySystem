package com.digital.epharmacy.entity;
/*
 * Author: Opatile Kelobang
 * Desc: Pharmacy entity store pharmacy id and pharmacy name
 * Date: 04 July 2020
 */


public class Pharmacy {
    // all the attributes of entity
    private String pharmacyId;
    private String pharmacyName;

    // builder pattern method constructor
    private Pharmacy(Builder builder)
    {
        this.pharmacyId = builder.pharmacyId;
        this.pharmacyName = builder.pharmacyName;
    }

    // getters for all attributes of entity Pharmacy
    public String getPharmacyId() {
        return pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    // to string method for Pharmacy entity
    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyId=" + pharmacyId +
                ", pharmacyName='" + pharmacyName + '\'' +
                '}';
    }

    // add setters using building pattern
    public static class Builder
    {
        private String pharmacyId;
        private String pharmacyName;

        public Builder setPharmacyID(String pharmacyId) {
            this.pharmacyId = pharmacyId;
            return this;
        }

        public Builder setPharmacyName(String pharmacyName) {
            this.pharmacyName = pharmacyName;
            return this;
        }

        // Copy method for Pharmacy entity
        public Builder copy (Pharmacy pharmacy)
        {
            this.pharmacyId = pharmacy.pharmacyId;
            this.pharmacyName = pharmacy.pharmacyName;
            return this;
        }

        // Instance for Builder Pattern
        public Pharmacy build() {
            return new Pharmacy(this);
        }
    }
}

