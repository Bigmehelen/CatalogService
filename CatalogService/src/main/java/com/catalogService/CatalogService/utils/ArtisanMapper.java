package com.catalogService.CatalogService.utils;

import com.catalogService.CatalogService.dto.request.CreateArtisanRequest;
import com.catalogService.CatalogService.dto.response.ArtisanResponse;
import com.catalogService.CatalogService.model.Artisan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArtisanMapper {
    Artisan toEntity(CreateArtisanRequest request);
    ArtisanResponse toResponse(Artisan artisan);
    List<ArtisanResponse> toResponseList(List<Artisan> artisans);
}
