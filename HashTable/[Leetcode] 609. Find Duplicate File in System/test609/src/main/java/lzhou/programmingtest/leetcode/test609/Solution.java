package lzhou.programmingtest.leetcode.test609;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String p : paths) {
            String[] tokens = p.split(" ");
            String base = tokens[0];
            for (int i=1; i<tokens.length; ++i) {
                String fileContent = tokens[i];
                int splitPoint = fileContent.indexOf("(");
                String fileName = fileContent.substring(0, splitPoint);
                String content = fileContent.substring(splitPoint+1, fileContent.length()-1);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<String>());
                }
                map.get(content).add(base+"/"+fileName);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (String k: map.keySet()) {
            if (map.get(k).size()>1) {
                result.add(map.get(k));
            }
        }
        return result;
    }
}
