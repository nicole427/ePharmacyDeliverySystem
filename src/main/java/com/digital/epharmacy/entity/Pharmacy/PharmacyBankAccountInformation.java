package com.digital.epharmacy.entity.Pharmacy;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation store pharmacy id using composition, bank name, account number, branch code and beneficiary reference
 * Date: 04 July 2020
 */
@Entity
@Table(name = "bank_account")
public class PharmacyBankAccountInformation {
    @Id
    @Column(name = "id")
    private String bankAccountId;
    @NotBlank(message = "Bank name is required")
    private String bankName;
    @NotNull(message = "Account number is required")
    @Range(min = 1, max = 2147483647, message = "Account number is required")
    private int accountNumber;
    @NotNull(message = "Branch code is required")
    @Range(min = 1, max = 2147483647, message = "Branch code is required")
    private int branchCode;
    @NotBlank(message = "Beneficiary Reference is required")
    private String beneficiaryReference;

    protected PharmacyBankAccountInformation(){

    }

    // builder pattern method constructor
    private PharmacyBankAccountInformation(Builder builder)
    {
        this.bankAccountId = builder.bankAccountId;
        this.bankName = builder.bankName;
        this.accountNumber = builder.accountNumber;
        this.branchCode = builder.branchCode;
        this.beneficiaryReference = builder.beneficiaryReference;
    }

    // getters for all attributes of entity PharmacyBankAccountInformation
    public String getBankAccountId() {
        return bankAccountId;
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
                "pharmacyID=" + bankAccountId +
                ", bankName='" + bankName + '\'' +
                ", accountNumber=" + accountNumber +
                ", branchCode=" + branchCode +
                ", beneficiaryReference='" + beneficiaryReference + '\'' +
                '}';
    }

    // add setters using building pattern
    public static class Builder
    {
        private String bankAccountId;
        private String bankName;
        private int accountNumber;
        private int branchCode;
        private String beneficiaryReference;

        public Builder setBankAccountId(String bankAccountId)
        {
            this.bankAccountId = bankAccountId;
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
            this.bankAccountId = pharmacyBankAccountInformation.bankAccountId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyBankAccountInformation that = (PharmacyBankAccountInformation) o;
        return bankAccountId.equals(that.bankAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountId);
    }
}


