package com.digital.epharmacy.entity.Catalogue;

import com.digital.epharmacy.entity.Pharmacy.Pharmacy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
Name: Nelson Mpyana
 * Desc: Pharmacy Catalogue Entity composed of Pharmacy
 * Date: 04/07/2020
 */

@Entity
public class PharmacyCatalogue {
    @Id
    @Column(name = "id")
    private String catalogueId;
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
        this.catalogueId = builder.catalogueId;
        this.catalogueName = builder.catalogueName;
        this.catalogueDescription = builder.catalogueDescription;

    }
    // Mutators (getters) for pharmacy catalogue

    public String getCatalogueId() {
        return catalogueId;
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
                "pharmacyId=" + catalogueId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueDescription='" + catalogueDescription + '\'' +
                '}';
    }

    //create a inner static builder class (Immutable)
    public static class Builder {

        private String catalogueId;
        private String catalogueName, catalogueDescription;

        public Builder setCatalogueId(String pharmacyId) {
            this.catalogueId = pharmacyId;
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
            this.catalogueId = pharmacyCatalogue.catalogueId;
            this.catalogueName = pharmacyCatalogue.catalogueName;
            this.catalogueDescription = pharmacyCatalogue.catalogueDescription;
            return this;
        }

        public PharmacyCatalogue build() {

            return new PharmacyCatalogue(this);
        }
    }
}
