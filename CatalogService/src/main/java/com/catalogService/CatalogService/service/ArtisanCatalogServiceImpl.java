package com.catalogService.CatalogService.service;

import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;
import com.catalogService.CatalogService.repository.ArtisanRepository;
import com.catalogService.CatalogService.strategy.ArtisanSearchStrategy;
import com.catalogService.CatalogService.strategy.SearchStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtisanCatalogServiceImpl implements ArtisanCatalogService {

    private final SearchStrategyFactory searchStrategyFactory;
    private final ArtisanRepository artisanRepository;

    @Override
    public List<Artisan> searchArtisans(Category category, String criteria) {
        ArtisanSearchStrategy strategy = searchStrategyFactory.getStrategy(category);
        return strategy.search(criteria);
    }

    @Override
    public Artisan saveArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }
    
    @Override
    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }
}
