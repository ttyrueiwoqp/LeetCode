package accepted.Q531_Q540;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a URL such
 * as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class Q535 {

    private static final String DOMAIN = "http://tinyurl.com/";
    Map<String, String> m = new HashMap<>();
    Map<String, String> m2 = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (m2.containsKey(longUrl)) {
            return m2.get(longUrl);
        }

        String key;
        do {
            key = java.util.UUID.randomUUID().toString().substring(0, 6);
        } while (m.containsKey(key));

        m.put(key, longUrl);
        m2.put(longUrl, key);
        return DOMAIN + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return m.get(shortUrl.substring(DOMAIN.length()));
    }
}
