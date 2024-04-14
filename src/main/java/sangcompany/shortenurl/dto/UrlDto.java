package sangcompany.shortenurl.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shorturl")
@Data
public class UrlDto {

    @Id
    private String id;
    private String originalUrl;
    private String shortUrl;
}
