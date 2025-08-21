package com.andyelder.service;

import com.andyelder.model.LegacyInventoryItem;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service // This tells Spring Boot this is a service component
public class MigrationService {

    private static final Logger logger = Logger.getLogger(MigrationService.class.getName());

    // Simulates fetching data from a legacy system (like a mainframe or old database)
    public LegacyInventoryItem fetchFromLegacySystem(String itemCode) {
        logger.info("📦 Fetching data from legacy system for item: " + itemCode);
        
        // In a real tool, this would connect to a database or API
        // Here we simulate finding an item
        if ("OLD-12345".equals(itemCode)) {
            return new LegacyInventoryItem("OLD-12345", "Widget Assembly", 150, "WAREHOUSE-A");
        } else {
            logger.warning("Item not found in legacy system: " + itemCode);
            return null;
        }
    }

    // Transforms the legacy data into a new format for a modern system (like SAP)
    public String transformData(LegacyInventoryItem legacyItem) {
        if (legacyItem == null) {
            return "❌ Transformation failed: No data to transform";
        }

        logger.info("🔄 Transforming data for item: " + legacyItem.getItemCode());
        
        // Example transformation logic:
        // 1. Convert old SKU to new format
        // 2. Map old warehouse codes to new ones
        // 3. Apply business rules to quantities
        
        String newSku = "NEW-" + legacyItem.getItemCode().split("-")[1];
        String newWarehouse = legacyItem.getWarehouseLocation().replace("WAREHOUSE-", "WH-");
        
        String transformedData = String.format(
            "Transformed Item: SKU=%s, Desc='%s', Qty=%d, Location=%s",
            newSku, legacyItem.getDescription(), legacyItem.getQuantityOnHand(), newWarehouse
        );
        
        logger.info("✅ Transformation successful: " + transformedData);
        return transformedData;
    }

    // Simulates sending the transformed data to a new system
    public boolean loadToNewSystem(String transformedData) {
        logger.info("🚀 Sending data to new SAP system: " + transformedData);
        
        // In a real tool, this would call a REST API or database for SAP
        // Simulate a successful upload
        logger.info("✅ Data successfully migrated to new system!");
        return true;
    }

    // Main method that orchestrates the entire migration for one item
    public String migrateItem(String itemCode) {
        logger.info("\n=== Starting migration for item: " + itemCode + " ===");
        
        try {
            // 1. EXTRACT: Get data from legacy system
            LegacyInventoryItem legacyData = fetchFromLegacySystem(itemCode);
            
            if (legacyData == null) {
                return "Migration failed: Item not found in legacy system";
            }
            
            // 2. TRANSFORM: Convert the data to new format
            String transformedData = transformData(legacyData);
            
            // 3. LOAD: Send data to new system
            boolean success = loadToNewSystem(transformedData);
            
            return success ? "✅ Migration completed successfully!" : "❌ Migration failed during load.";
            
        } catch (Exception e) {
            logger.severe("❌ Critical error during migration: " + e.getMessage());
            return "❌ Migration failed due to an error: " + e.getMessage();
        }
    }
}
