package com.digital.epharmacy.entity.Catalogue;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
Name: Nelson Mpyana
 * Desc: Pharmacy Catalogue Entity composed of Pharmacy
 * Date: 04/07/2020
 */


public class PharmacyCatalogue {
    //naming entity attributes and assigning their variable values
    //This class has the Foreign key
    @Id
    private String pharmacyId;
    @NotNull(message = "Catalogue Name is required")
    private String catalogueName;
    @NotNull(message = "Catalogue Description is required")
    private String catalogueDescription;
    @ManyToOne
    @JoinColumn(name = "pharmacyId")
    private Pharmacy pharmacy;
    protected PharmacyCatalogue(){}
    //constructor for Builder class
    private PharmacyCatalogue(Builder builder) {
        this.pharmacyId = builder.pharmacyId;
        this.catalogueName = builder.catalogueName;
        this.catalogueDescription = builder.catalogueDescription;

    }
    // Mutators (getters) for pharmacy catalogue

    public String getPharmacyId() {
        return pharmacyId;
    }

    public String getCatalogueName() {
        return catalogueName;
    }

    public String getCatalogueDescription() {
        return catalogueDescription;
    }
    //to String method

    @Override
    public String toString() {
        return "PharmacyCatalogue{" +
                "pharmacyId=" + pharmacyId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDescription='" + catalogueDescription + '\'' +
                '}';
    }

    //create a inner static builder class (Immutable)
    public static class Builder {

        private String pharmacyId;
        private String catalogueName, catalogueDescription;

        public Builder setPharmacyId(String pharmacyId) {
            this.pharmacyId = pharmacyId;
            return this;
        }

        public Builder setCatalogueName(String catalogueName) {
            this.catalogueName = catalogueName;
            return this;
        }

        public Builder setCatalogueDescription(String catalogueDescription) {
            this.catalogueDescription = catalogueDescription;
            return this;
        }

        // Builder copy method that create instance of ContactInformation and makes a copy out of it
        public PharmacyCatalogue.Builder copy(PharmacyCatalogue pharmacyCatalogue) {
            this.pharmacyId = pharmacyCatalogue.pharmacyId;
            this.catalogueName = pharmacyCatalogue.catalogueName;
            this.catalogueDescription = pharmacyCatalogue.catalogueDescription;
            return this;
        }

        public PharmacyCatalogue build() {

            return new PharmacyCatalogue(this);
        }
    }
}
