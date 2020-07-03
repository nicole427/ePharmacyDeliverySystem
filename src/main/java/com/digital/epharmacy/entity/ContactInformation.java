package com.digital.epharmacy.entity;
/*
 * Author: Nicole Hawthorne
 * Desc: ContactInformation entity composed of UserProfile
 *       and Pharmacy entity that stores user and pharmacy contact information
 * Date: 03/07/2020
 * */
//main class
public class ContactInformation {
    //naming entity attributes and assigning their variable values
    private int userId,pharmacyId,primaryNumber,secondaryNumber;
    
    //constructor for Builder class
    private ContactInformation (Builder builder){
        this.userId = builder.userId;
        this.pharmacyId = builder.pharmacyId;
        this.primaryNumber = builder.primaryNumber;
        this.secondaryNumber = builder.secondaryNumber;
    }

    //getters to get all values of attributes
    public int getUserId() {
        return userId;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public int getPrimaryNumber() {
        return primaryNumber;
    }

    public int getSecondaryNumber() {
        return secondaryNumber;
    }

    // toString to display what is in the ContactInformation class
    @Override
    public String toString() {
        return "ContactInformation{" +
                "userId=" + userId +
                ", pharmacyId=" + pharmacyId +
                ", primaryNumber=" + primaryNumber +
                ", secondaryNumber=" + secondaryNumber +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder{
        private int userId,pharmacyId,primaryNumber,secondaryNumber;

        //setting UserId value using builder pattern
        public Builder setUserId(int userId){
            this.userId = userId;
            return this;
        }
        //setting PharmacyId value using builder pattern
        public Builder setPharmacyId(int pharmacyId){
            this.pharmacyId = pharmacyId;
            return this;
        }
        //setting PrimaryNumber value using builder pattern
        public Builder setPrimaryNumber(int primaryNumber){
            this.primaryNumber = primaryNumber;
            return this;
        }
        //setting SecondaryNumber value using builder pattern
        public Builder setSecondaryNumber(int secondaryNumber){
            this.secondaryNumber = secondaryNumber;
            return this;
        }

        // Builder copy method that create instance of ContactInformation and makes a copy out of it
        public Builder copy(ContactInformation contactInformation){
            this.userId = contactInformation.userId;
            this.pharmacyId = contactInformation.pharmacyId;
            this.primaryNumber = contactInformation.primaryNumber;
            this.secondaryNumber = contactInformation.secondaryNumber;
            return this;
        }

        //creating and instance of this class
        public ContactInformation build(){
            return new ContactInformation(this);
        }
    }
}
