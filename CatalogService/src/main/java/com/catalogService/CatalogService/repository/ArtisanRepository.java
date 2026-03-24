package com.catalogService.CatalogService.repository;

import com.catalogService.CatalogService.model.Artisan;
import com.catalogService.CatalogService.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
    List<Artisan> findByCategory(Category category);
    List<Artisan> findByCategoryAndSkillsContainingIgnoreCase(Category category, String skill);
}
