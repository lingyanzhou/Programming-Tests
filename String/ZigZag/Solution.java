public class Solution {
    public static String convert(String s, int numRows) {
        if (s.length()<2 || numRows==1) {
            return s;
        }
        int len = s.length();
        int segNum = ((int)Math.ceil(len/(numRows-1.0)));
        int numCols = 0;
        
        if (segNum%2==1) {
            numCols = segNum/2*(numRows-1)+1;
        } else {
            numCols = (segNum/2-1)*(numRows-1)+(len-1)%(numRows-1);
        }
        StringBuilder out = new StringBuilder();
        {
            int repeatCount = 0;
            while (true) {
                int tmp = 2*(numRows-1)*repeatCount;
                if (tmp>=len) {
                    break;
                }
                out.append(s.charAt(tmp));
                for (int j=0; j<numRows-2; ++j) {
                    out.append(' ');
                }
                repeatCount++;
            }
            out.append('\n');
        }
        for (int i=1; i<numRows-1; i++) {
            int repeatCount = 0;
            while (true) {
                int tmp = 2*(numRows-1)*repeatCount+i;
                if (tmp>=len) {
                    break;
                }
                out.append(s.charAt(tmp));
                for (int j=0; j<numRows-2-i; ++j) {
                    out.append(' ');
                }
                tmp = 2*(numRows-1)*(repeatCount+1)-i;
                if (tmp>=len) {
                    break;
                }
                out.append(s.charAt(tmp));
                for (int j=0; j<i-1; ++j) {
                    out.append(' ');
                }
                repeatCount++;
            }
            out.append('\n');
        }
        {
            int repeatCount = 0;
            while (true) {
                int tmp = 2*(numRows-1)*(repeatCount)+(numRows-1);
                
                if (tmp>=len) {
                    break;
                }
                out.append(s.charAt(tmp));
                for (int j=0; j<numRows-2; ++j) {
                    out.append(' ');
                }
                repeatCount++;
            }
            out.append('\n');
        }
        return out.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("abbcc", 4));
    }
}
