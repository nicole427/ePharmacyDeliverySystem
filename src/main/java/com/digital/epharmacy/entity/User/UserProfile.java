package com.digital.epharmacy.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/*
 * Author: Nicole Hawthorne
 * Desc: UserProfile entity for registered user information
 * Date: 03/07/2020
 * */

/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key as ID also added noBlank values each entity so that its not empty
 and changed default constructor to protected.
 Lastly added equals and hashcode for Id
 * Date: 25/10/2020
 * */
//main class
@Entity
public class UserProfile {
    //naming entity attributes and assigning their variable values
    @Id
    @Column(name = "id")
    private String userId;
    @NotBlank(message = "Username is required")
    private String userName;
    @NotBlank(message = "User Surname is required")
    private String userSurname;
    @NotBlank(message = "Gender is required")
    private String gender;

    protected UserProfile(){}

    //constructor for Builder class
    private UserProfile (Builder builder){
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userSurname = builder.userSurname;
        this.gender = builder.gender;

    }
    //getters to get all values of attributes
    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public String getGender() {
        return gender;
    }


    // toString to display what is in the UserProfile class

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder{
        //same assigned attributes in main class with variable values
        private String userId;
        private String userName, userSurname, gender;


        //setting userId value using builder pattern
        public Builder setUserId(String userId){
            this.userId = userId;
            return this;
        }
        //setting userName value using builder pattern
        public Builder setUserName(String userName){
            this.userName = userName;
            return this;
        }
        //setting userSurname value using builder pattern
        public Builder setUserSurname(String userSurname){
            this.userSurname = userSurname;
            return this;
        }
        //setting Gender value using builder pattern
        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }

        // Builder copy method that create instance of UserProfile and makes a copy out of it
        public Builder copy(UserProfile userProfile){
            this.userId = userProfile.userId;
            this.userName = userProfile.userName;
            this.userSurname = userProfile.userSurname;
            this.gender = userProfile.gender;
            return this;

        }
        //creating and instance of this class
        public UserProfile build(){
            return new UserProfile(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
