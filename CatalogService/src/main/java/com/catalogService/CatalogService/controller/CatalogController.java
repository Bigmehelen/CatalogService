package com.catalogService.CatalogService.controller;

import com.catalogService.CatalogService.dto.response.ArtisanResponse;
import com.catalogService.CatalogService.dto.request.CreateArtisanRequest;
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
    public ResponseEntity<List<ArtisanResponse>> searchArtisans(
            @RequestParam Category category,
            @RequestParam(required = false) String criteria) {
        
        List<ArtisanResponse> artisans = artisanCatalogService.searchArtisans(category, criteria);
        return ResponseEntity.ok(artisans);
    }
    
    @PostMapping("/artisans")
    @org.springframework.security.access.prepost.PreAuthorize("hasAuthority('ROLE_ARTISAN')")
    public ResponseEntity<ArtisanResponse> addArtisan(@RequestBody CreateArtisanRequest request) {
        ArtisanResponse savedArtisan = artisanCatalogService.createArtisan(request);
        return ResponseEntity.ok(savedArtisan);
    }

    @GetMapping("/artisans")
    public ResponseEntity<List<ArtisanResponse>> getAllArtisans() {
        return ResponseEntity.ok(artisanCatalogService.getAllArtisans());
    }
}
