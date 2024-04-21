package sangcompany.shortenurl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sangcompany.shortenurl.dto.UrlDto;
import sangcompany.shortenurl.util.IdGenerator;

@Service
public class UrlDtoCreator {

    @Value("${shorturl.ip}")
    private String serverIp;

    private final IdGenerator idGenerator;

    public UrlDtoCreator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public UrlDto CreateUrlDto(String originalUrl) {
        UrlDto urlDto = new UrlDto();
        String urlId = idGenerator.generateRandomString(4);

        urlDto.setId(urlId);
        urlDto.setOriginalUrl(originalUrl);
        urlDto.setShortUrl(serverIp + "/" + urlId);

        return urlDto;
    }
}
