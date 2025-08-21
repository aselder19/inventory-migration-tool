package com.andyelder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryMigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryMigrationApplication.class, args);
        System.out.println("✅ Inventory Migration Tool started!");
        System.out.println("📍 Health check: http://localhost:8080/api/migrate/health");
        System.out.println("🔄 Migrate an item: http://localhost:8080/api/migrate/item/OLD-12345");
    }
}
