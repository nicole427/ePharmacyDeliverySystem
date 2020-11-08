package com.digital.epharmacy.factory.Catalogue;
/*
* Name: Nelson Mpyana
* Desc: Prescription Item factory class
* Date : 05/07/2020
 */
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.util.GenericHelper;

public class PrescriptionItemFactory {

    public static PrescriptionItem createPrescriptionItem(int prescriptionNumber, String prescriptionType, String prescribingDoctor)
    {
        String prescriptionId = GenericHelper.generateId();

        PrescriptionItem prescriptionItem = new PrescriptionItem.Builder()
                .setPrescriptionId(prescriptionId)
                .setPrescriptionNumber(prescriptionNumber)
                .setPrescriptionType(prescriptionType)
                .setPrescribingDoctor(prescribingDoctor)
                .build();
        return prescriptionItem;
    }
}
