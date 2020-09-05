package com.digital.epharmacy.service.PrescriptionItem.impl;
/*
 * Author: Nelson Mpyana
 * Date: 02/09/2020
 * Desc: PrescriptionItem Service Impl
 * */
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.repository.PharmacyCatalogue.Impl.PharmacyCatalogueRepositoryImpl;
import com.digital.epharmacy.repository.PrescriptionItem.Impl.PrescriptionItemRepositoryImpl;
import com.digital.epharmacy.repository.PrescriptionItem.PrescriptionItemRepository;
import com.digital.epharmacy.service.PrescriptionItem.PrescriptionItemService;

import java.util.Set;

public class PrescriptionItemServiceImpl implements PrescriptionItemService {

    private static PrescriptionItemServiceImpl service = null;
    private PrescriptionItemRepository repository;

    private PrescriptionItemServiceImpl(){
        this.repository = PrescriptionItemRepositoryImpl.getRepository();
    }

    public static PrescriptionItemServiceImpl getService() {
        if (service == null) service = new PrescriptionItemServiceImpl();
        return service;
    }

    @Override
    public Set<PrescriptionItem> getAll() {
        return this.repository.getAll();
    }

    @Override
    public PrescriptionItem create(PrescriptionItem prescriptionItem) {
        return this.repository.create(prescriptionItem);
    }

    @Override
    public PrescriptionItem read(String prescriptionItem) {
        return this.repository.read(prescriptionItem);
    }

    @Override
    public PrescriptionItem update(PrescriptionItem prescriptionItem) {
        return this.repository.update(prescriptionItem);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
