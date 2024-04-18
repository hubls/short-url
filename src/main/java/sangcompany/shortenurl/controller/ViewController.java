package sangcompany.shortenurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;
import sangcompany.shortenurl.dto.UrlDto;
import sangcompany.shortenurl.service.UrlService;

@Controller
public class ViewController {
    private final UrlService urlService;

    @Autowired
    public ViewController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("title", "안녕하세요");
        return "pages/main";
    }

    @GetMapping("/{id}")
    public RedirectView getUrlByOriginalUrl(@PathVariable("id") String id) {
        UrlDto url = urlService.getOriginalUrl(id);

        if (url == null) {
            return new RedirectView("/"); // id에 해당하는 URL이 없으면 루트로 리다이렉트
        }

        return new RedirectView(url.getOriginalUrl());
    }
}
