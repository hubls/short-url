package sangcompany.shortenurl.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "shorturl")
@Data
public class UrlDto {

    @Id
    private String id;
    private String originalUrl;
    private String shortUrl;
    @CreatedDate
    private Date createTime;
    @Version
    private Integer version;
}
