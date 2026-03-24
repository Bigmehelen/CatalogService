package com.catalogService.CatalogService.strategy;

import com.catalogService.CatalogService.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SearchStrategyFactory {

    @Autowired
    private List<ArtisanSearchStrategy> strategies;

    public ArtisanSearchStrategy getStrategy(Category category) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(category))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No search strategy found for category: " + category));
    }
}
