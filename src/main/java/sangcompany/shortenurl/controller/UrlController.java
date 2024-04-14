package sangcompany.shortenurl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sangcompany.shortenurl.service.UrlService;

@RestController
@RequestMapping("/url")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public String createUrl(@RequestParam("url") String url) {
        String shortUrl = urlService.createShortUrl(url);
        return shortUrl;
    }

}