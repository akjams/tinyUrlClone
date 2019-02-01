package tinyurl.entities;

/** Immutable DB object representing a TinyUrl. */
public class TinyUrl {
    private final String sourceUrl;
    private final String targetUrl;

    public TinyUrl(String sourceUrl, String targetUrl) {
        this.sourceUrl = sourceUrl;
        this.targetUrl = targetUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    @Override
    public String toString() {
        return String.format("{sourceUrl: %s, targetUrl: %s}", sourceUrl, targetUrl);
    }
}
