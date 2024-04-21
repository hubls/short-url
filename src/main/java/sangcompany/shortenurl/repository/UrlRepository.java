package sangcompany.shortenurl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sangcompany.shortenurl.dto.UrlDto;


public interface UrlRepository extends MongoRepository<UrlDto, String> {
    UrlDto findOriginalUrlById(String id);
    boolean existsById(String id);
}
