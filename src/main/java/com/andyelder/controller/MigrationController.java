package com.andyelder.controller;

import com.andyelder.service.MigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/migrate")
public class MigrationController {

    @Autowired
    private MigrationService migrationService;

    // REST endpoint to migrate a specific item
    @PostMapping("/item/{itemCode}")
    public String migrateItem(@PathVariable String itemCode) {
        return migrationService.migrateItem(itemCode);
    }

    // A simple health check endpoint
    @GetMapping("/health")
    public String healthCheck() {
        return "Inventory Migration Tool is running! ✅";
    }
}
