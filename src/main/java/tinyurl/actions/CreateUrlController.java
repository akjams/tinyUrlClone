package tinyurl.actions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tinyurl.db.LocalTinyUrlRepository;
import tinyurl.db.TinyUrlRepository;
import tinyurl.entities.TinyUrl;

@RestController
public class CreateUrlController {

    private final TinyUrlRepository repo;

    CreateUrlController() {
        this.repo = LocalTinyUrlRepository.getInstance();
    }

    @PostMapping("/api/urls")
    public TinyUrl createUrl(@RequestBody TinyUrl tinyUrl) {
        // TODO: support user-specified sourceUrl.
        // TODO: validate tinyUrl.targetUrl.
        return repo.create(tinyUrl.getTargetUrl());
    }
}
