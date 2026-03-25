package com.catalogService.CatalogService.dto.response;

import com.catalogService.CatalogService.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtisanResponse {
    private Long id;
    private String name;
    private Category category;
    private String skills;
    private String profileImageUrl;
    private String description;
    private Double priceRange;
}
