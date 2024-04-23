package sangcompany.shortenurl.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sangcompany.shortenurl.dto.UrlDto;
import sangcompany.shortenurl.repository.UrlRepository;

@Slf4j
@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final UrlDtoCreator urlDtoCreator;

    @Autowired
    public UrlService(UrlRepository urlRepository, UrlDtoCreator urlDtoCreator) {
        this.urlRepository = urlRepository;
        this.urlDtoCreator = urlDtoCreator;
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
        return urlDtoCreator.CreateUrlDto(originalUrl);
    }
}
