package com.catalogService.CatalogService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artisans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artisan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private String profileImageUrl;

    private String description;
    
    private Double priceRange;
}
