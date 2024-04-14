package sangcompany.shortenurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sangcompany.shortenurl.dto.UrlDto;
import sangcompany.shortenurl.repository.UrlRepository;
import sangcompany.shortenurl.util.SecureRandomStringGenerator;

import java.util.List;

@Service
public class UrlService {

    @Value("${shorturl.ip}")
    private String serverIp;
    private final UrlRepository urlRepository;
    private final SecureRandomStringGenerator secureRandomStringGenerator;

    @Autowired
    public UrlService(UrlRepository urlRepository, SecureRandomStringGenerator secureRandomStringGenerator) {
        this.urlRepository = urlRepository;
        this.secureRandomStringGenerator = secureRandomStringGenerator;
    }

    public String createShortUrl(String originalUrl) {
        UrlDto urlDto = generateUrlDto(originalUrl);
        urlRepository.save(urlDto);
        return urlDto.getShortUrl();
    }

    public UrlDto getOriginalUrl(String id) {
        return urlRepository.findOriginalUrlById(id);
    }

    private UrlDto generateUrlDto(final String originalUrl) {
        UrlDto urlDto = new UrlDto();
        String urlId = secureRandomStringGenerator.generateRandomString(4);

        urlDto.setId(urlId);
        urlDto.setOriginalUrl(originalUrl);
        urlDto.setShortUrl(serverIp + "/" + urlId);

        return urlDto;
    }
}
