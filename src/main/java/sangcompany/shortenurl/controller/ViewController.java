package sangcompany.shortenurl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import sangcompany.shortenurl.repository.dto.UrlDto;
import sangcompany.shortenurl.service.UrlService;

import java.util.Optional;

@Slf4j
@Controller
public class ViewController {
    private final UrlService urlService;

    @Autowired
    public ViewController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String index() {
        return "pages/index";
    }

    @GetMapping("/{id}")
    public RedirectView getUrlByOriginalUrl(@PathVariable("id") String id) {
        Optional<UrlDto> optionalUrl = Optional.ofNullable(urlService.getOriginalUrl(id));

        return optionalUrl
                .map(url -> new RedirectView(url.getOriginalUrl())) // 값이 있으면 해당 URL로 리다이렉트
                .orElseGet(() -> new RedirectView("/")); // 값이 없으면 루트로 리다이렉트
    }

    @GetMapping("/policy/privacy")
    public String privacy() {
        return "pages/privacy";
    }
}
