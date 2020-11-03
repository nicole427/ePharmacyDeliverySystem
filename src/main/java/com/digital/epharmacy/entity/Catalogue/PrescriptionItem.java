package com.digital.epharmacy.entity.Catalogue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
Author: Nelson Mpyana, 217029620
Date: 03/07/2019
Class Entity: PrescriptionItem (this class will store information about the the prescription )
Version: 1.0

 */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 * */

public class PrescriptionItem {
    //declaring the Variables
    @Id
    private int prescriptionNumber;
    @NotNull(message = "Prescription number is required")
    private String prescriptionType;
    @NotNull(message = "Prescribing doctor number is required")
    private String prescribingDoctor;

protected PrescriptionItem (){}
    //Creating a builder static class. An immutable class
    public static class Builder {
        int prescriptionNumber;
        String prescriptionType, prescribingDoctor;

        public Builder setPrescriptionNumber(int prescriptionNumber) {
            this.prescriptionNumber = prescriptionNumber;
            return this;
        }

        public Builder setPrescriptionType(String prescriptionType) {
            this.prescriptionType = prescriptionType;
            return this;
        }

        public Builder setPrescribingDoctor(String prescribingDoctor) {
            this.prescribingDoctor = prescribingDoctor;
            return this;
        }

        // copy method
        public Builder copy(PrescriptionItem prescriptionItem) {
            this.prescriptionType = prescriptionItem.prescriptionType;
            this.prescriptionNumber = prescriptionItem.prescriptionNumber;
            this.prescribingDoctor = prescriptionItem.prescribingDoctor;
            return this;
        }
        public PrescriptionItem build() {
            return new PrescriptionItem(this);
        }
    }

    //A private constructor
    private PrescriptionItem(Builder builder) {
        this.prescriptionNumber = builder.prescriptionNumber;
        this.prescribingDoctor = builder.prescribingDoctor;
        this.prescriptionType = builder.prescriptionType;
    }

    //Mutatators
    public int getPrescriptionNumber() {
        return prescriptionNumber;
    }

    public String getPrescriptionType() {
        return prescriptionType;
    }

    public String getPrescribingDoctor() {
        return prescribingDoctor;
    }

    //To string method
    @Override
    public String toString() {
        return "Prescription Item{" +
                "prescription Number=" + prescriptionNumber +
                ", prescription Type='" + prescriptionType + '\'' +
                ", prescribing Doctor='" + prescribingDoctor + '\'' +
                '}';
    }
}
