package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - Medical Aid factory - 05 July 2020
import com.digital.epharmacy.entity.User.MedicalAid;

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
