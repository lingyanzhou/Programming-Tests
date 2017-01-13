import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int find(int[] ar, int start, int end, int index) {
        assert end>start;
        assert index>=start;
        assert end>index;
        
        int center=ar[end-1];
        int centerStartIndex = start; 
        int rightStartIndex = start; 
        for (int i=start; i<end; ++i) {
            if (ar[i]<center) {
                int tmp = ar[i];
                ar[i] = ar[rightStartIndex];
                ar[rightStartIndex] = ar[centerStartIndex];
                ar[centerStartIndex] = tmp;
                centerStartIndex++;
                rightStartIndex++;
            } else if (ar[i]>center) {
                
            } else {
                int tmp = ar[i];
                ar[i] = ar[rightStartIndex];
                ar[rightStartIndex] = tmp;
                rightStartIndex++;
            }
        }
        if (centerStartIndex>index) {
            return find(ar, start, centerStartIndex, index);
        } else if (rightStartIndex<=index) {
            return find(ar, rightStartIndex, end, index);
        } else {
            return center;
        }
    }
 
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
       
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        assert n%2==1;
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
        }
        System.out.print(find(ar, 0, n, (n-1)/2));
    }    
}
