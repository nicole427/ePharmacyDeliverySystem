package com.digital.epharmacy.factory;
//Nicole Hawthorne - Medical Aid factory - 05 July 2020
import com.digital.epharmacy.entity.MedicalAid;
import com.digital.epharmacy.entity.UserProfile;

public class MedicalAidFactory{

    public static MedicalAid createMedicalAid(String userId, int userMedicalAidNumber, String medicalAidName, String medicalAidScheme){
       MedicalAid medicalAid = new MedicalAid.Builder()
               .setUserId(userId)
               .setUserMedicalAidNumber(userMedicalAidNumber)
               .setMedicalAidName(medicalAidName)
               .setMedicalAidScheme(medicalAidScheme)
               .build();
        return  medicalAid;
    }
}
