package com.catalogService.CatalogService.strategy;
import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;

import java.util.List;

public interface ArtisanSearchStrategy {
    boolean supports(Category category);
    List<Artisan> search(String criteria);
}
