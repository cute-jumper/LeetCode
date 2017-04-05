public class Codec {

    Map<String, Integer> url2int = new HashMap<>();
    Map<Integer, String> int2url = new HashMap<>();
    String prefix = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (url2int.containsKey(longUrl)) {
            return prefix + url2int.get(longUrl);
        }
        url2int.put(longUrl, url2int.size());
        int2url.put(int2url.size(), longUrl);
        return prefix + (url2int.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer key = Integer.valueOf(shortUrl.substring(shortUrl.lastIndexOf('/') + 1));
        return int2url.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
