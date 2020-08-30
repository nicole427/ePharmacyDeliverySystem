package com.digital.epharmacy.entity.User;
/*
 * Author: Nicole Hawthorne
 * Desc: MedicalAid entity composed of UserProfile entity that stores user Medical Aid information if there is any.
 * Date: 03/07/2020
 * */
//main class
public class MedicalAid {
    //naming entity attributes and assigning their variable values
    private int  userMedicalAidNumber;
    private String medicalAidName, medicalAidScheme;
    private String userId;
    //constructor for Builder class
    private MedicalAid (Builder builder){
        this.userId = builder.userId;
        this.userMedicalAidNumber = builder.userMedicalAidNumber;
        this.medicalAidName = builder.medicalAidName;
        this.medicalAidScheme = builder.medicalAidScheme;
     
    }
    
    //getters to get all values of attributes
    public String getUserId() {
        return userId;
    }

    public int getUserMedicalAidNumber() {
        return userMedicalAidNumber;
    }

    public String getMedicalAidName() {
        return medicalAidName;
    }

    public String getMedicalAidScheme() {
        return medicalAidScheme;
    }

    // toString to display what is in the Medical Aid class
    @Override
    public String toString() {
        return "MedicalAid{" +
                "userId=" + userId +
                ", userMedicalAidNumber=" + userMedicalAidNumber +
                ", medicalAidName='" + medicalAidName + '\'' +
                ", medicalAidScheme='" + medicalAidScheme + '\'' +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder{
        //same assigned attributes in main class with variable values
        private int  userMedicalAidNumber;
        private String medicalAidName, medicalAidScheme;
        private String userId;

        //setting UserId value using builder pattern
        public Builder setUserId(String userId){
            this.userId = userId;
            return this;
        }
        //setting User Medical Aid  value using builder pattern
        public Builder setUserMedicalAidNumber(int userMedicalAidNumber){
            this.userMedicalAidNumber = userMedicalAidNumber;
            return this;
        }
        //setting Medical Aid Name value using builder pattern
        public Builder setMedicalAidName(String medicalAidName){
            this.medicalAidName = medicalAidName;
            return this;
        }
        //setting Medical Aid Scheme value using builder pattern
        public Builder setMedicalAidScheme(String medicalAidScheme){
            this.medicalAidScheme = medicalAidScheme;
            return this;
        }
        
        // Builder copy method that create instance of MedicalAid and makes a copy out of it
        public Builder copy(MedicalAid medicalAid){
            this.userId = medicalAid.userId;
            this.userMedicalAidNumber = medicalAid.userMedicalAidNumber;
            this.medicalAidName = medicalAid.medicalAidName;
            this.medicalAidScheme = medicalAid.medicalAidScheme;
            return this;

        }
        //creating and instance of this class
        public MedicalAid build(){
            return new MedicalAid(this);
        }
    }
}