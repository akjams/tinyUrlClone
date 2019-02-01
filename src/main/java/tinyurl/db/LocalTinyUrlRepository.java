package tinyurl.db;

import tinyurl.entities.TinyUrl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LocalTinyUrlRepository implements TinyUrlRepository {

    private static final String SOURCE_URL_BASE = "http://localhost:8080/";

    // sourceUrl -> TinyUrl.
    private Map<String, TinyUrl> tinyUrlMap;

    // Number of urls created. Naively used as sourceUrl hash.
    private long urlCount;

    private static final LocalTinyUrlRepository INSTANCE = new LocalTinyUrlRepository();

    public static LocalTinyUrlRepository getInstance() {
        return INSTANCE;
    }

    private LocalTinyUrlRepository() {
        this.tinyUrlMap = new HashMap<>();
    }

    @Override
    public synchronized TinyUrl create(String targetUrl) {
        urlCount++;
        String sourceUrl = SOURCE_URL_BASE + urlCount;
        TinyUrl tinyUrl = new TinyUrl(sourceUrl, targetUrl);
        tinyUrlMap.put(sourceUrl, tinyUrl);
        return tinyUrl;
    }

    @Override
    public TinyUrl get(String sourceUrlPath) {
        String sourceUrl = SOURCE_URL_BASE + sourceUrlPath;
        if (!tinyUrlMap.containsKey(sourceUrl)) {
            throw new IllegalArgumentException("No url found for: " + sourceUrl);
        }
        return tinyUrlMap.get(sourceUrl);
    }
}
