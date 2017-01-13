import java.util.*;
public class Solution {
    static void quickSort(int[] ar, int start, int end) {
        if (end-start<=1) {
            return;
        }
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
        printArray(ar);
        quickSort(ar, start, centerStartIndex);
        quickSort(ar, rightStartIndex, end);
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
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
        }
        quickSort(ar, 0, n);
    }
}
