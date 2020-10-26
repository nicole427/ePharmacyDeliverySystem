package com.digital.epharmacy.entity.Pharmacy;

import java.io.Serializable;
import java.util.Objects;

public class PharmacyBankID implements Serializable {
    String pharmacyId, bankAccountId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyBankID that = (PharmacyBankID) o;
        return pharmacyId.equals(that.pharmacyId) &&
                bankAccountId.equals(that.bankAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pharmacyId, bankAccountId);
    }
}
