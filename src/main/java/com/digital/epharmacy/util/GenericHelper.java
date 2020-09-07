package com.digital.epharmacy.util;
/*
* Nicole Hawthorne - Adding a method to help generate random id - 05 July 2020
* Ayabulela Mahlathini - adding method to handle payment servies, get payment date and notification - 05 July 2020
* */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class GenericHelper {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    //handling payment services
    public static String handlePaymentServices(String paymentMethod, double total){
        boolean complete = false;

        switch (paymentMethod) {
            case "yoco":

                //cash on delivery code goes here
                // with conditional statement to check status from the payment gateway

                complete = true; //assuming payment is completed for now
                break;
            case "paypal":

                //paypal integration code goes here
                // with conditional statement to check status from the payment gateway

                complete = true; //assuming payment is completed for now
                break;
            case "zapper":

                //zapper (qr payment) integration code goes here
                // with conditional statement to check status from the payment gateway

                complete = true; //assuming payment is completed for now
                break;
            default:
                complete = false;

        }

        String status = complete ? "successful" : "unsuccessful";

        return status;
    }

    //getting the date for the exact time the payment was done
    public static String paymentDate(){
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy");

        return formatter.format(date);
    }

    //handling notifications after receiving payment status
    public static String handleNotifications(String status) {
        String notification = null;
        switch (status){
            case "successful":
                notification = "Payment Successful";
                break;
            case "unsuccessful":
                notification = "Payment Unsuccessful";
                break;
            default:
                notification = "In Process";
                break;
        }
        return notification;
    }

    public static String handleOrderNotifications(String status) {
        String notification = null;
        switch (status.toLowerCase()){
            case "completed":
                notification = "Order Completed, To be delivered";
                break;
            case "awaiting payment":
                notification = "Order Incomplete, Payment not received";
                break;
            default:
                notification = "Order In Process";
                break;
        }
        return notification;
    }

    public static String handleOrderStatus(String paymentStatus){

        String orderStatus = null;

        switch (paymentStatus) {
            case "successful":
                orderStatus = "Completed";
            case "unsuccessful":
                orderStatus = "Awaiting Payment";
            default: orderStatus = "Processing";
        }
        return orderStatus;
    }

}


