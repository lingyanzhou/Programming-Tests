import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long getXorXorSequenceElement(long index) {
        long ret = 0;
        if (index<0) {
            return 0;
        } else if (index%8==0) {
            ret = index;
        } else if ((index-1)%8==0) {
            ret = index;
        } else if ((index-2)%8==0) {
            ret = 2;
        } else if ((index-3)%8==0) {
            ret = 2;
        } else if ((index-4)%8==0) {
            ret = 2+index;
        } else if ((index-5)%8==0) {
            ret = 2+index;
        } else if ((index-6)%8==0) {
            ret = 0;
        } else if ((index-7)%8==0) {
            ret = 0;
        }
        return ret;
    }
    
    public static long getXorSequenceElement(long index) {
        long ret = 0;
        if (index<0) {
            return 0;
        } else if (index%4==0) {
            ret = index;
        } else if ((index-1)%4==0) {
            ret = 1;
        } else if ((index+2)%4==0) {
            ret = 1+index;
        } else if ((index+1)%4==0) {
            ret = 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            long result = 0;
            result= getXorXorSequenceElement(R)^getXorXorSequenceElement(L-1);
            System.out.println(result);
        }
    }
}
