package com.catalogService.CatalogService.service;

import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;
import com.catalogService.CatalogService.dto.request.CreateArtisanRequest;
import com.catalogService.CatalogService.dto.response.ArtisanResponse;
import com.catalogService.CatalogService.repository.ArtisanRepository;
import com.catalogService.CatalogService.strategy.ArtisanSearchStrategy;
import com.catalogService.CatalogService.strategy.SearchStrategyFactory;
import com.catalogService.CatalogService.utils.ArtisanMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtisanCatalogServiceImpl implements ArtisanCatalogService {

    private final SearchStrategyFactory searchStrategyFactory;
    private final ArtisanRepository artisanRepository;
    private final ArtisanMapper artisanMapper;

    @Override
    public List<ArtisanResponse> searchArtisans(Category category, String criteria) {
        ArtisanSearchStrategy strategy = searchStrategyFactory.getStrategy(category);
        List<Artisan> artisans = strategy.search(criteria);
        return artisanMapper.toResponseList(artisans);
    }

    @Override
    public ArtisanResponse saveArtisan(CreateArtisanRequest request) {
        Artisan artisanToSave = artisanMapper.toEntity(request);
        Artisan savedArtisan = artisanRepository.save(artisanToSave);
        return artisanMapper.toResponse(savedArtisan);
    }
    
    @Override
    public List<ArtisanResponse> getAllArtisans() {
        List<Artisan> artisans = artisanRepository.findAll();
        return artisanMapper.toResponseList(artisans);
    }
}
