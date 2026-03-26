# CatalogService Architecture

The following diagram illustrates the architecture of the `CatalogService`, showing the relationships between controllers, services, repositories, models, and strategy patterns.

```mermaid
classDiagram
    class CatalogController {
        +searchArtisans(Category, String) List~ArtisanResponse~
        +createArtisan(CreateArtisanRequest) ArtisanResponse
        +getAllArtisans() List~ArtisanResponse~
    }

    class ArtisanCatalogService {
        <<interface>>
        +searchArtisans(Category, String) List~ArtisanResponse~
        +createArtisan(CreateArtisanRequest) ArtisanResponse
        +getAllArtisans() List~ArtisanResponse~
    }

    class ArtisanCatalogServiceImpl {
        -SearchStrategyFactory searchStrategyFactory
        -ArtisanRepository artisanRepository
        -ArtisanMapper artisanMapper
        +searchArtisans(Category, String) List~ArtisanResponse~
        +createArtisan(CreateArtisanRequest) ArtisanResponse
        +getAllArtisans() List~ArtisanResponse~
    }

    class ArtisanRepository {
        <<interface>>
        +save(Artisan) Artisan
        +findAll() List~Artisan~
        +findById(Long) Optional~Artisan~
    }

    class Artisan {
        -Long id
        -String name
        -Category category
        -String skills
        -String profileImageUrl
        -String description
        -Double priceRange
    }

    class Category {
        <<enumeration>>
        BRAIDER
        NAIL_TECH
        OTHER
    }

    class ArtisanMapper {
        <<interface>>
        +toResponse(Artisan) ArtisanResponse
        +toEntity(CreateArtisanRequest) Artisan
        +toResponseList(List~Artisan~) List~ArtisanResponse~
    }

    class SearchStrategyFactory {
        -Map~Category, ArtisanSearchStrategy~ strategies
        +getStrategy(Category) ArtisanSearchStrategy
    }

    class ArtisanSearchStrategy {
        <<interface>>
        +search(String) List~Artisan~
    }

    class BraiderSearchStrategy {
        +search(String) List~Artisan~
    }

    class NailTechSearchStrategy {
        +search(String) List~Artisan~
    }

    class UserServiceClient {
        +getUserProfile(String) UserProfile
    }

    CatalogController --> ArtisanCatalogService : uses
    ArtisanCatalogService <|.. ArtisanCatalogServiceImpl : implements
    ArtisanCatalogServiceImpl --> SearchStrategyFactory : uses
    ArtisanCatalogServiceImpl --> ArtisanRepository : uses
    ArtisanCatalogServiceImpl --> ArtisanMapper : uses
    SearchStrategyFactory o-- ArtisanSearchStrategy : manages
    ArtisanSearchStrategy <|.. BraiderSearchStrategy : implements
    ArtisanSearchStrategy <|.. NailTechSearchStrategy : implements
    ArtisanRepository --> Artisan : manages
    Artisan --> Category : has
    ArtisanCatalogServiceImpl --> UserServiceClient : uses
```
