///*
// * Author: Matsobane Nelson Mpyana
// * Desc: CatalogueItemImpl Test
// * Date: 30 August 2020
// */
//
//package com.digital.epharmacy.repository.PrescriptionRepository.Impl;
//import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
//import com.digital.epharmacy.factory.Catalogue.PrescriptionItemFactory;
//import com.digital.epharmacy.repository.PrescriptionItem.Impl.PrescriptionItemRepositoryImpl;
//import com.digital.epharmacy.repository.PrescriptionItem.PrescriptionItemRepository;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runners.MethodSorters;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class PrescriptionItemRepositoryImplTest {
//    private static PrescriptionItemRepository repository ;
//    private static PrescriptionItem prescriptionItem = PrescriptionItemFactory.createPrescriptionItem(365,"Medical",
//            "Dr Kgomotso" );
//
//    @Order(1)
//    @Test
//    public void a_create() {
//        PrescriptionItem created = repository.create(prescriptionItem);
//        Assert.assertEquals(prescriptionItem.getPrescriptionNumber(), created.getPrescriptionNumber());
//        System.out.println("Created: " + created);
//    }
//
//    @Order(2)
//    @Test
//    public void b_read() throws Exception {
//        PrescriptionItem read = repository.read(prescriptionItem.getPrescribingDoctor());
//        System.out.println("Read: " + read);
//    }
//
//    @Order(3)
//    @Test
//    public void c_update() {
//        PrescriptionItem updated = new PrescriptionItem.Builder().copy(prescriptionItem).setPrescribingDoctor("Dr Mulaudzi").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Order(5)
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(prescriptionItem.getPrescribingDoctor());
//        Assert.assertTrue(deleted);
//        if (deleted)
//            System.out.println("Entry Deleted");
//    }
//
//    @Order(4)
//    @Test
//    public void d_getAll() {
//
//    }
//
//}
