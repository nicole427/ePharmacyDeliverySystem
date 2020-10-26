package com.digital.epharmacy.entity.User;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/*
 * Author: Nicole Hawthorne
 * Desc: MedicalAid entity composed of UserProfile entity that stores user Medical Aid information if there is any.
 * Date: 03/07/2020
 *
 * Edited By Opatile Kelobang
 * Date: 25 September 2020
 *
 * Modified: 26 October 2020
 * Updated Method call for Read by Pharmacy name
 *
 * */

@Entity
public class MedicalAid {
    //naming entity attributes and assigning their variable values
    @Id
    @Column(name = "id")
    private String medicalAidId;
    @NotNull(message = "Medical aid number is required")
    @Range(min = 1, max = 2147483647, message = "Medical aid number is required")
    private int userMedicalAidNumber;
    @NotBlank(message = "Medical aid scheme is required")
    private String medicalAidScheme;
    @NotBlank(message = "Medical aid name is required")
    private String medicalAidName;

    protected MedicalAid(){}

    //constructor for Builder class
    private MedicalAid (Builder builder){
        this.medicalAidId = builder.medicalAidId;
        this.userMedicalAidNumber = builder.userMedicalAidNumber;
        this.medicalAidName = builder.medicalAidName;
        this.medicalAidScheme = builder.medicalAidScheme;
     
    }
    
    //getters to get all values of attributes
    public String getMedicalAidId() {
        return medicalAidId;
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
                "userId=" + medicalAidId +
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
        private String medicalAidId;

        //setting UserId value using builder pattern
        public Builder setMedicalAidId(String medicalAidId){
            this.medicalAidId = medicalAidId;
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
            this.medicalAidId = medicalAid.medicalAidId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalAid that = (MedicalAid) o;
        return medicalAidId.equals(that.medicalAidId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalAidId);
    }
}