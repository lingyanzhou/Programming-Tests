package lzhou.programmingtest.leetcode.test12;

public class Solution2 {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        int powTen = 1;
        int powTenExp =0;
        while (n>=powTen*10) {
            powTen*=10;
            powTenExp+=1;
        }
        StringBuilder sb = new StringBuilder(100);
        while (n!=0) {
            int d = n/powTen;
            if (d!=0) {
                digitToRoman(d, powTenExp, sb);
            }
            n%=powTen;
            powTen/=10;
            powTenExp-=1;
        }
        
        return sb.toString();
    }
    
    private void digitToRoman(int n, int powTenExp, StringBuilder sb) {
        sb.append(table[powTenExp][n]);
    }
    String[][] table = {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM","","","","","",""}};
}
