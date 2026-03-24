package com.catalogService.CatalogService.controller;

import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;
import com.catalogService.CatalogService.service.ArtisanCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final ArtisanCatalogService artisanCatalogService;

    @GetMapping("/search")
    public ResponseEntity<List<Artisan>> searchArtisans(
            @RequestParam Category category,
            @RequestParam(required = false) String criteria) {
        
        List<Artisan> artisans = artisanCatalogService.searchArtisans(category, criteria);
        return ResponseEntity.ok(artisans);
    }
    
    @PostMapping("/artisans")
    public ResponseEntity<Artisan> addArtisan(@RequestBody Artisan artisan) {
        Artisan savedArtisan = artisanCatalogService.saveArtisan(artisan);
        return ResponseEntity.ok(savedArtisan);
    }

    @GetMapping("/artisans")
    public ResponseEntity<List<Artisan>> getAllArtisans() {
        return ResponseEntity.ok(artisanCatalogService.getAllArtisans());
    }
}
