package com.digital.epharmacy.entity.Catalogue;
/*
Author: Nelson Mpyana, 217029620
Date: 03/07/2019
Class Entity: PrescriptionItem (this class will store information about the the prescription )
Version: 1.0

 */
public class PrescriptionItem {
    //declaring the Variables
    int prescriptionNumber;
    String prescriptionType, prescribingDoctor;

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
