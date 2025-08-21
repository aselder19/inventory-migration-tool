package com.andyelder.model;

// This class represents an inventory item in the LEGACY system
public class LegacyInventoryItem {
    private String itemCode; // Old SKU format
    private String description;
    private int quantityOnHand;
    private String warehouseLocation;

    // Constructor
    public LegacyInventoryItem(String itemCode, String description, int quantityOnHand, String warehouseLocation) {
        this.itemCode = itemCode;
        this.description = description;
        this.quantityOnHand = quantityOnHand;
        this.warehouseLocation = warehouseLocation;
    }

    // Getters and Setters (Required for Spring Boot to work with the data)
    public String getItemCode() { return itemCode; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantityOnHand() { return quantityOnHand; }
    public void setQuantityOnHand(int quantityOnHand) { this.quantityOnHand = quantityOnHand; }

    public String getWarehouseLocation() { return warehouseLocation; }
    public void setWarehouseLocation(String warehouseLocation) { this.warehouseLocation = warehouseLocation; }

    @Override
    public String toString() {
        return "LegacyInventoryItem{" +
                "itemCode='" + itemCode + '\'' +
                ", description='" + description + '\'' +
                ", quantityOnHand=" + quantityOnHand +
                ", warehouseLocation='" + warehouseLocation + '\'' +
                '}';
    }
}
