package com.digital.epharmacy.factory.User;
//Nicole Hawthorne - Medical Aid factory - 05 July 2020
import com.digital.epharmacy.entity.User.MedicalAid;
import com.digital.epharmacy.util.GenericHelper;

public class MedicalAidFactory{

    public static MedicalAid createMedicalAid(int userMedicalAidNumber, String medicalAidName, String medicalAidScheme){
        String userId = GenericHelper.generateId();
        MedicalAid medicalAid = new MedicalAid.Builder()
               .setUserId(userId)
               .setUserMedicalAidNumber(userMedicalAidNumber)
               .setMedicalAidName(medicalAidName)
               .setMedicalAidScheme(medicalAidScheme)
               .build();
        return  medicalAid;
    }
}
