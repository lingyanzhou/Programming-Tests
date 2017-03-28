package lzhou.programmingtest.leetcode.test535;

import java.util.*;

public class Codec {
    HashMap<Long, String> db = new HashMap<Long, String>(); 
    static final int BASE = 62;
    static final long MAX_POSSIBLE = (long)Math.pow(BASE, 6);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long code = (longUrl.hashCode()%MAX_POSSIBLE+MAX_POSSIBLE)%MAX_POSSIBLE;
        //System.out.println(code);
        
        db.put(code, longUrl);
        StringBuffer encodedId = new StringBuffer();
        for (int i=0; i<6; ++i) {
            int tmp = (int)(code % BASE);
            char c= '_';
            if (tmp<26) {
                c=(char)(tmp+'a');
            } else if (tmp<52) {
                c=(char)(tmp-26+'A');
            } else {
                c=(char)(tmp-52+'0');
            }
            code = code/BASE;
            encodedId.insert(0, c);
        }
        //System.out.println(encodedId.toString());
        
        return "http://tinyurl.com/"+encodedId.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        assert shortUrl.length()==25;
        long code = 0;
        for (int i=19; i<25; ++i) {
            char c = shortUrl.charAt(i);
            code *= BASE;
            if (Character.isLowerCase(c)) {
                code += c-'a';
            } else if (Character.isUpperCase(c)) {
                code += c-'A'+26;
            } else {
                code += c-'0'+52;
            }
        }
        //System.out.println(code);
        return db.get(code);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
