import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static int highestDifferentBit(long in1, long in2) {
        int bit = 63;
        for (bit=63; bit>=0; --bit) {
            if ((in1>>bit)!=(in2>>bit)) {
                break;
            }
        }
        return bit;
        //return (int)(Math.log(in)/Math.log(2));
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] ar = new long[n][2];
        for(int i=0;i<n;i++){
            ar[i][0]=in.nextLong(); 
            ar[i][1]=in.nextLong(); 
            int highestBit = highestDifferentBit(ar[i][0], ar[i][1]);
            long result = (ar[i][0]>>(highestBit+1)) <<(highestBit+1);
            System.out.println(result);
        } 
    }
}
