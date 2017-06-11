package lzhou.programmingtest.leetcode.test616;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public String addBoldTag(String s, String[] dict) {
        List<int[]> intervals = new ArrayList<int[]>();
        for (String d : dict) {
            int start = -1;
            while (true) {
                start = s.indexOf(d, start+1);
                if (start==-1) {
                    break;
                } else {
                    intervals.add(new int[]{start, start+d.length()});
                }
            }
        }
        
        Collections.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                int ret = Integer.compare(i1[0], i2[0]);
                if (ret==0) {
                    ret = -Integer.compare(i1[1], i2[1]);
                }
                return ret;
            }
        });
        
        List<int[]> merged = new ArrayList<int[]>();
        int [] tmp = null;
        for (int[] intvl : intervals) {
            if (tmp==null) {
                tmp = new int[]{intvl[0], intvl[1]};
            } else if (intvl[0]<=tmp[1]) {
                tmp[1] = Math.max(intvl[1], tmp[1]);
            } else {
                merged.add(tmp);
                tmp = intvl;
            }
        }
        if (tmp!=null) {
            merged.add(tmp);
        }
        
        if (merged.size()==0) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        int[] last = null;
        for (int[] intvl : merged) {
            if (first) {
                first = false;
                last = intvl;
                sb.append(s.substring(0, intvl[0]));
                sb.append("<b>");
                sb.append(s.substring(intvl[0], intvl[1]));
                sb.append("</b>");
            } else {
                sb.append(s.substring(last[1], intvl[0]));
                last = intvl;
                sb.append("<b>");
                sb.append(s.substring(intvl[0], intvl[1]));
                sb.append("</b>");
            }
        }
        sb.append(s.substring(last[1]));
        return sb.toString();
    }
}
