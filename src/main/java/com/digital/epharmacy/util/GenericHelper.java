package com.digital.epharmacy.util;
//Nicole Hawthorne - Adding a method to help generate random id - 05 July 2020
//Matthew Pearce - Added a method to generate random order ID
import com.digital.epharmacy.entity.UserProfile;

import java.util.UUID;

public class GenericHelper {
    public static String generateId() { return UUID.randomUUID().toString(); }
    public static int generateOrderId() { return Integer.parseInt(UUID.randomUUID().toString()); }
}


