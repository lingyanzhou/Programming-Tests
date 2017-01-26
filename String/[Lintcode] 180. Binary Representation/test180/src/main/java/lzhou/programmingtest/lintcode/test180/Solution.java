package lzhou.programmingtest.lintcode.test180;

import java.util.*;

/**
 * Boundary cases
 *  
 *  * Integer part is zero
 *  * String does not have fractional part
 *  * String has fractional part but is all 0
 *  * Both parts can be too large to fit in int or long type
 * 
 */
public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        try {
            int dotIndex = n.indexOf(".");
            if (dotIndex==-1) {
                    return binaryRepresentationInt(n).toString();
            }
            String intergerPart = n.substring(0, dotIndex);
            StringBuffer integerPartBinary = binaryRepresentationInt(intergerPart);
            
            String fractionalPart = n.substring(dotIndex+1);
            StringBuffer fractionalPartBinary = binaryRepresentationFractional(fractionalPart);
            if (fractionalPartBinary.length()!=0) {
                integerPartBinary.append('.');
                integerPartBinary.append(fractionalPartBinary);
            }
            return integerPartBinary.toString();
        } catch (Exception e) {
            return "ERROR";
        }
    }
    
    private StringBuffer binaryRepresentationInt(String n) throws NumberFormatException {
        StringBuffer sb = new StringBuffer();
        int[] bigint = stringToBigInt(n);
        
        while (!allZeros(bigint)) {
            //System.out.println(Arrays.toString(bigint));
            if (bigIntDivideBy2(bigint)) {
                sb.insert(0,1);
            } else {
                sb.insert(0,0);
            }
        }
        
        if (sb.length()==0)
            sb.append(0);
        return sb;
    } 
    
    private StringBuffer binaryRepresentationFractional(String n) throws NumberFormatException  {
        StringBuffer sb = new StringBuffer();
        int[] bigint = stringToBigInt(n);
        while (sb.length()<33 && !allZeros(bigint)) {
            //System.out.println(Arrays.toString(bigint));
            if (bigIntMult2(bigint)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        //System.out.println(Arrays.toString(bigint));
        if (sb.length()<=32) {
            return sb;
        } else {
            throw new NumberFormatException();
        }
    }
    
    private int[] stringToBigInt(String n) {
        int[] bigint = new int[n.length()];
        for (int i=0; i<n.length(); ++i) {
            bigint[n.length()-1-i] = n.charAt(i)-'0';
        }
        return bigint;
    }
    
    private boolean bigIntMult2(int[] num) {
        int c = 0;
        for (int i=0; i<num.length; ++i) {
            int tmp = num[i]*2+c;
            c = tmp/10;
            num[i] = tmp%10;
        }
        return c!=0;
    }
    
    private boolean bigIntDivideBy2(int[] num) {
        assert num.length>0;
        boolean isOdd = (num[0]%2==1);
        int c = 0;
        for (int i=num.length-1; i>=0; --i) {
            int tmp = (num[i]+10*c);
            c = tmp%2;
            num[i] = tmp/2;
        }
        return isOdd;
    }
    
    private boolean allZeros(int[] num) {
        for (int i=0; i<num.length; ++i) {
            if (num[i]!=0) {
                return false;
            }
        }
        return true;
    }
}
