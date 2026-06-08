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
        -ArtisanSearchStrategy artisanSearchStrategy
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

    class ArtisanSearchStrategy {
        +search(Category, String) List~Artisan~
    }

    class UserServiceClient {
        +getUserProfile(String) UserProfile
    }

    CatalogController --> ArtisanCatalogService : uses
    ArtisanCatalogService <|.. ArtisanCatalogServiceImpl : implements
    ArtisanCatalogServiceImpl --> ArtisanSearchStrategy : uses
    ArtisanCatalogServiceImpl --> ArtisanRepository : uses
    ArtisanCatalogServiceImpl --> ArtisanMapper : uses
    ArtisanRepository --> Artisan : manages
    Artisan --> Category : has
    ArtisanCatalogServiceImpl --> UserServiceClient : uses
```
