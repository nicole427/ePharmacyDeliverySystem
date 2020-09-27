package com.digital.epharmacy.entity.Pharmacy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation store pharmacy id using composition, bank name, account number, branch code and beneficiary reference
 * Date: 04 July 2020
 */
@Entity
public class PharmacyBankAccountInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pharmacyID;
    @NotBlank(message = "Bank name is required")
    private String bankName;
    @NotNull(message = "Account number is required")
    private int accountNumber;
    @NotNull(message = "Branch Code is required")
    private int branchCode;
    @NotBlank(message = "Beneficiary Reference is required")
    private String beneficiaryReference;

    private PharmacyBankAccountInformation(){

    }

    // builder pattern method constructor
    private PharmacyBankAccountInformation(Builder builder)
    {
        this.pharmacyID = builder.pharmacyID;
        this.bankName = builder.bankName;
        this.accountNumber = builder.accountNumber;
        this.branchCode = builder.branchCode;
        this.beneficiaryReference = builder.beneficiaryReference;
    }

    // getters for all attributes of entity PharmacyBankAccountInformation
    public String getPharmacyID() {
        return pharmacyID;
    }

    public String getBankName() {
        return bankName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public String getBeneficiaryReference() {
        return beneficiaryReference;
    }

    // to string method for PharmacyBankAccountInformation entity
    @Override
    public String toString() {
        return "PharmacyBankAccountInformation{" +
                "pharmacyID=" + pharmacyID +
                ", bankName='" + bankName + '\'' +
                ", accountNumber=" + accountNumber +
                ", branchCode=" + branchCode +
                ", beneficiaryReference='" + beneficiaryReference + '\'' +
                '}';
    }

    // add setters using building pattern
    public static class Builder
    {
        private String pharmacyID;
        private String bankName;
        private int accountNumber;
        private int branchCode;
        private String beneficiaryReference;

        public Builder setPharmacyID(String pharmacyID)
        {
            this.pharmacyID = pharmacyID;
            return this;
        }

        public Builder setBankName(String bankName)
        {
            this.bankName = bankName;
            return this;
        }

        public Builder setAccountNumber(int accountNumber)
        {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setBranchCode(int branchCode)
        {
            this.branchCode = branchCode;
            return this;
        }

        public Builder setBeneficiaryReference(String beneficiaryReference)
        {
            this.beneficiaryReference = beneficiaryReference;
            return this;
        }

        // Copy method for PharmacyBankAccountInformation entity
        public Builder copy (PharmacyBankAccountInformation pharmacyBankAccountInformation)
        {
            this.pharmacyID = pharmacyBankAccountInformation.pharmacyID;
            this.bankName = pharmacyBankAccountInformation.bankName;
            this.accountNumber = pharmacyBankAccountInformation.accountNumber;
            this.branchCode = pharmacyBankAccountInformation.branchCode;
            this.beneficiaryReference = pharmacyBankAccountInformation.beneficiaryReference;
            return this;
        }
        // Instance for Builder Pattern
        public PharmacyBankAccountInformation build()
        {
            return new PharmacyBankAccountInformation(this);
        }
    }
}


