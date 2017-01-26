package lzhou.programmingtest.leetcode.test271;

import java.util.*;

public class Codec 
{
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String s: strs) {
            for (int i=0; i<s.length(); ++i) {
                char c = s.charAt(i);
                if (c=='\0') {
                    sb.append('\\');
                } else if (c=='\\') {
                    sb.append('\\');
                }
                sb.append(c);
            }
            sb.append('\0');
        }
        return sb.toString();
    }

    public List<String> decode(String data) {
        List<String> ret = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<data.length(); ++i) {
            char c = data.charAt(i);
            if (c=='\\' && i<data.length()-1 && data.charAt(i+1)=='\0') {
                sb.append('\0');
                i+=1;
            } else if (c=='\\' && i<data.length()-1 && data.charAt(i+1)=='\\') {
                sb.append('\\');
                i+=1;
            } else if (c=='\0'){
                ret.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        return ret;
    }
}
