package com.digital.epharmacy.entity.Catalogue;

/*
 * Name: Nelson Mpyana
 * Desc: Catalogue Item Entity composed of Pharmacy Catalogue
 * Date: 04/07/2020
 */
public class CatalogueItem {

    //naming entity attributes and assigning their variable values
    private int itemNumber, itemQuantity;
    private String itemName, itemDescription;
    private double itemPrice;

    //constructor for Builder class
    private CatalogueItem(Builder builder) {
        this.itemDescription = builder.itemDescription;
        this.itemName = builder.itemName;
        this.itemNumber = builder.itemNumber;
        this.itemQuantity = builder.itemQuantity;
        this.itemPrice = builder.itemPrice;
    }

    //getters to get all values of attributes
    public int getItemNumber() {
        return itemNumber;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    // toString to display what is in the ContactInformation class
    @Override
    public String toString() {
        return "CatalogueItem{" +
                "itemNumber=" + itemNumber +
                ", itemQuantity=" + itemQuantity +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }

    //inner Builder class to implement the builder pattern
    public static class Builder {
        //setting  value using builder pattern
        int itemNumber, itemQuantity;
        String itemName, itemDescription;
        double itemPrice;

        public Builder setItemNumber(int itemNumber) {
            this.itemNumber = itemNumber;
            return this;
        }

        public Builder setItemQuantity(int itemQuantity) {
            this.itemQuantity = itemQuantity;
            return this;
        }

        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setDescription(String itemDescription) {
            this.itemDescription = itemDescription;
            return this;
        }

        public Builder setPrice(Double itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        //Copy method
        public CatalogueItem.Builder copy(CatalogueItem catalogueItem){
            this.itemNumber = catalogueItem.itemNumber;
            this.itemQuantity = catalogueItem.itemQuantity;
            this.itemName = catalogueItem.itemName;
            this.itemDescription = catalogueItem.itemDescription;
            this.itemPrice = catalogueItem.itemPrice;
            return this;
        }

        //creating an instance
        public CatalogueItem build() {
            return new CatalogueItem(this);
        }
    }
}

