package com.catalogService.CatalogService.service;

import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;

import java.util.List;

public interface ArtisanCatalogService {
    List<Artisan> searchArtisans(Category category, String criteria);
    Artisan saveArtisan(Artisan artisan);
    List<Artisan> getAllArtisans();
}
