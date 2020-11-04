package com.digital.epharmacy.service.PrescriptionItem.impl;
/*
 * Author: Nelson Mpyana
 * Date: 02/09/2020
 * Desc: PrescriptionItem Service Impl
 * */
import com.digital.epharmacy.entity.Catalogue.PrescriptionItem;
import com.digital.epharmacy.repository.PrescriptionItem.PrescriptionItemRepository;
import com.digital.epharmacy.service.PrescriptionItem.PrescriptionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PrescriptionItemServiceImpl implements PrescriptionItemService {

    @Autowired
    private PrescriptionItemRepository repository;

    @Override
    public Set<PrescriptionItem> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public PrescriptionItem create(PrescriptionItem prescriptionItem) {
        return this.repository.save(prescriptionItem);
    }

    @Override
    public PrescriptionItem read(String prescriptionItem) {
        return this.repository.findById(prescriptionItem).orElse(null);
    }

    @Override
    public PrescriptionItem update(PrescriptionItem prescriptionItem) {
        return create(prescriptionItem);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)){
            return false;
        } else {
            return true;
        }
    }
}
