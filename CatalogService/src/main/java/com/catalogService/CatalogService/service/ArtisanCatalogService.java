package com.catalogService.CatalogService.service;

import com.catalogService.CatalogService.model.Category;
import com.catalogService.CatalogService.dto.request.CreateArtisanRequest;
import com.catalogService.CatalogService.dto.response.ArtisanResponse;

import java.util.List;

public interface ArtisanCatalogService {
    List<ArtisanResponse> searchArtisans(Category category, String criteria);
    ArtisanResponse saveArtisan(CreateArtisanRequest request);
    List<ArtisanResponse> getAllArtisans();
}
