package tinyurl.db;

import tinyurl.entities.TinyUrl;

/** Interface for TinyUrl CRUD ops. */
public interface TinyUrlRepository {

    TinyUrl create(String targetUrl);

    TinyUrl get(String sourceUrl);

}
