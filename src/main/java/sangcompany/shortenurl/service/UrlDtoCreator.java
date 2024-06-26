package sangcompany.shortenurl.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sangcompany.shortenurl.repository.dto.UrlDto;
import sangcompany.shortenurl.repository.UrlRepository;
import sangcompany.shortenurl.utils.IdGenerator;

@Slf4j
@Service
public class UrlDtoCreator {

    @Value("${shorturl.ip}")
    private String serverIp;
    private static final int ID_LENGTH = 4;

    private final IdGenerator idGenerator;
    private final UrlRepository urlRepository;

    public UrlDtoCreator(IdGenerator idGenerator, UrlRepository urlRepository) {
        this.idGenerator = idGenerator;
        this.urlRepository = urlRepository;
    }

    public UrlDto CreateUrlDto(String originalUrl) {
        String urlId;
        do {
            urlId = idGenerator.generateRandomString(ID_LENGTH);
        } while (urlRepository.existsById(urlId)); // 존재하는지 확인하여 중복되면 다시

        UrlDto urlDto = new UrlDto();
        urlDto.setId(urlId);
        urlDto.setOriginalUrl(addHttpPrefixIfMissing(originalUrl));
        urlDto.setShortUrl(serverIp + "/" + urlId);

        return urlDto;
    }

    private String addHttpPrefixIfMissing(String url) {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            return url;
        }

        return "http://".concat(url);
    }
}
