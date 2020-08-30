package com.digital.epharmacy.factory.Catalogue;
/*
* Name: Nelson Mpyana
* Desc: Prescription Item factory class
* Date : 05/07/2020
 */
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
public class PrescriptionItemFactory {

    public static PrescriptionItem createPrescriptionItem(int prescriptionNumber, String prescriptionType,
                                                      String prescribingDoctor)
    {
        PrescriptionItem prescriptionItem = new PrescriptionItem.Builder()
                .setPrescriptionNumber(prescriptionNumber)
                .setPrescriptionType(prescriptionType)
                .setPrescribingDoctor(prescribingDoctor)
                .build();
        return prescriptionItem;
    }
}
