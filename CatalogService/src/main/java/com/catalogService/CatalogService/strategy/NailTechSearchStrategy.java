package com.catalogService.CatalogService.strategy;

import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;
import com.catalogService.CatalogService.repository.ArtisanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class NailTechSearchStrategy implements ArtisanSearchStrategy {

    @Autowired
    private ArtisanRepository artisanRepository;

    @Override
    public boolean supports(Category category) {
        return Category.NAIL_TECH.equals(category);
    }

    @Override
    public List<Artisan> search(String criteria) {
        if (criteria == null || criteria.trim().isEmpty()) {
            return artisanRepository.findByCategory(Category.NAIL_TECH);
        }

        return artisanRepository.findByCategoryAndSkillsContainingIgnoreCase(Category.NAIL_TECH, criteria);
    }
}
