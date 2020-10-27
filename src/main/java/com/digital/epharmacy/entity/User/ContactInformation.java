package com.digital.epharmacy.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.util.Objects;


/*Author: Matthew Pearce
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 Also created the class for all userProfile composite keys
 * Date: 26/10/2020
 * */
//main class
//@IdClass(UserProfileAndPharmacyId.class)
@Entity
public class ContactInformation {
    //naming entity attributes and assigning their variable values
    @Id
    private String userId , pharmacyId;
    @NotNull(message = "Primary number is required")
    private int primaryNumber;
    @NotNull(message = "Secondary number is required")
    private int secondaryNumber;

    protected ContactInformation(){}
    
    //constructor for Builder class
    private ContactInformation (Builder builder){
        this.userId = builder.userId;
        this.pharmacyId = builder.pharmacyId;
        this.primaryNumber = builder.primaryNumber;
        this.secondaryNumber = builder.secondaryNumber;
    }

    //getters to get all values of attributes
    public String getUserId() {
        return userId;
    }

    public String getPharmacyId() {
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
        private int primaryNumber,secondaryNumber;
        private String userId;
        private String pharmacyId;

        //setting UserId value using builder pattern
        public Builder setUserId(String userId){
            this.userId = userId;
            return this;
        }
        //setting PharmacyId value using builder pattern
        public Builder setPharmacyId(String pharmacyId){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInformation that = (ContactInformation) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
