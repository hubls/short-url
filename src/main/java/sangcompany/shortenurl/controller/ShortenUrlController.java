package sangcompany.shortenurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import sangcompany.shortenurl.dto.UrlDto;
import sangcompany.shortenurl.service.UrlService;

@Controller
public class ShortenUrlController {
    private final UrlService urlService;

    @Autowired
    public ShortenUrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String index() {
        return "index"; // index.html을 반환
    }

    @GetMapping("/{id}")
    public RedirectView getUrlByOriginalUrl(@PathVariable("id") String id) {
        UrlDto url = urlService.getOriginalUrl(id);
        return new RedirectView(url.getOriginalUrl());
    }
}
