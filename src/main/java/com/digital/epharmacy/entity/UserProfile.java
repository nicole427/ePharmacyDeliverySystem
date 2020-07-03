package com.digital.epharmacy.entity;
/*
* Author: Nicole Hawthorne
* Desc: UserProfile entity for registered user information
* Date: 03/07/2020
* */
//main class
public class UserProfile {
    //naming entity attributes and assigning their variable values
    private int userId;
    private String userName, userSurname, gender;
    private int totalNumberOfOrders;
    private double totalOrderValue;

    //constructor for Builder class
    private UserProfile (Builder builder){
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userSurname = builder.userSurname;
        this.gender = builder.gender;
        this.totalNumberOfOrders = builder.totalNumberOfOrders;
        this.totalOrderValue = builder.totalOrderValue;
    }
    //getters to get all values of attributes
    public int getUserId() {
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

    public int getTotalNumberOfOrders() {
        return totalNumberOfOrders;
    }

    public double getTotalOrderValue() {
        return totalOrderValue;
    }
    // toString to display what is in the UserProfile class
    @Override
    public String toString() {
        return "UserProfile{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", gender='" + gender + '\'' +
                ", totalNumberOfOrders=" + totalNumberOfOrders +
                ", totalOrderValue=" + totalOrderValue +
                '}';
    }
    //inner Builder class to implement the builder pattern
    public static class Builder{
        //same assigned attributes in main class with variable values
        private int userId;
        private String userName, userSurname, gender;
        private int totalNumberOfOrders;
        private double totalOrderValue;

        //setting userId value using builder pattern
        public Builder setUserId(int userId){
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
        //setting TotalNumberOfOrders value using builder pattern
        public Builder setTotalNumberOfOrders(int totalNumberOfOrders){
            this.totalNumberOfOrders = totalNumberOfOrders;
            return this;
        }
        //setting TotalOrderValue value using builder pattern
        public Builder setTotalOrderValue(int totalOrderValue){
            this.totalOrderValue = totalOrderValue;
            return this;
        }
        // Builder copy method that create instance of UserProfile and makes a copy out of it
        public Builder copy(UserProfile userProfile){
            this.userId = userProfile.userId;
            this.userName = userProfile.userName;
            this.userSurname = userProfile.userSurname;
            this.gender = userProfile.gender;
            this.totalNumberOfOrders = userProfile.totalNumberOfOrders;
            this.totalOrderValue = userProfile.totalOrderValue;
            return this;

        }
        //creating and instance of this class
        public UserProfile build(){
            return new UserProfile(this);
        }
    }
}
