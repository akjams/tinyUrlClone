package tinyurl.actions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tinyurl.db.LocalTinyUrlRepository;
import tinyurl.db.TinyUrlRepository;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GetUrlController {

    private final TinyUrlRepository repo;

    GetUrlController() {
        this.repo = LocalTinyUrlRepository.getInstance();
    }

    @GetMapping("/{sourceUrlPath}")
    public void getUrl(@PathVariable String sourceUrlPath, HttpServletResponse response) {
        String targetUrl = repo.get(sourceUrlPath).getTargetUrl();
        response.setStatus(301 /* Moved Permanently */);
        response.setHeader("Location", targetUrl);
    }
}
