package com.catalogService.CatalogService.dto.request;

import com.catalogService.CatalogService.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateArtisanRequest {
    private String name;
    private Category category;
    private String skills;
    private String description;
    private String profileImageUrl;
    private Double priceRange;
}
