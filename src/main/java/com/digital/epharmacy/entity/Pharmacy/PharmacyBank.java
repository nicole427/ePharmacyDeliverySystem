package com.digital.epharmacy.entity.Pharmacy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PharmacyBankID.class)
public class PharmacyBank {

    @Id
    private String pharmacyId, bankAccountId;

    protected PharmacyBank(){}

    private PharmacyBank(Builder builder){
        this.pharmacyId = builder.pharmacyId;
        this.bankAccountId = builder.bankAccountId;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    @Override
    public String toString() {
        return "PharmacyBank{" +
                "pharmacyId='" + pharmacyId + '\'' +
                ", bankAccountId='" + bankAccountId + '\'' +
                '}';
    }

    public static class Builder {
        private String pharmacyId;
        private String bankAccountId;

        public Builder setPharmacyId(String pharmacyId)
        {
            this.pharmacyId = pharmacyId;
            return this;
        }

        public Builder setBankAccountId(String bankAccountId)
        {
            this.bankAccountId = bankAccountId;
            return this;
        }

        public Builder copy (PharmacyBank pharmacyBank){
            this.pharmacyId = pharmacyBank.pharmacyId;
            this.bankAccountId = pharmacyBank.bankAccountId;
            return this;
        }

        public PharmacyBank build(){
            return new PharmacyBank(this);
        }

    }
}
