package com.catalogService.CatalogService.strategy;

import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;
import com.catalogService.CatalogService.repository.ArtisanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArtisanSearchStrategy {

    private final ArtisanRepository artisanRepository;

    public List<Artisan> search(Category category, String criteria) {
        if (criteria == null || criteria.trim().isEmpty()) {
            return artisanRepository.findByCategory(category);
        }

        return artisanRepository.findByCategoryAndSkillsContainingIgnoreCase(category, criteria);
    }
}
