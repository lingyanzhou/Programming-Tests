import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            boolean isImpossible = false;
            for (int i=0; i<n; ++i) {
                int origTag = i+1;
                if (q[i]-2>origTag) {
                    isImpossible=true;
                    break;
                }
            }
            if (isImpossible) {
                System.out.println("Too chaotic");
            } else {
                int count = 0;
                ArrayList<Integer> backwardIndices = new ArrayList<Integer>();
                ArrayList<Integer> backwardOccurances = new ArrayList<Integer>();
                //Find whats pushed forward
                for (int i=0; i<n; i++) { 
                    final int origTag = i+1;
                    boolean notForward = true;
                    for (int j=1; j<=Math.min(i,2) ; j++) {
                        if (origTag==q[i-j]) {
                            count+=j;
                            notForward = false;
                            break;
                        }
                    }
                    if (notForward) {
                        backwardIndices.add(Integer.valueOf(i+1));
                    }
                    if (origTag>=q[i]) {
                        backwardOccurances.add(Integer.valueOf(q[i]));
                    }
                }
                //System.out.println(Arrays.toString(backwardIndices.toArray()));
                //System.out.println(Arrays.toString(backwardOccurances.toArray()));
                assert backwardIndices.size()==backwardOccurances.size();

                while (backwardIndices.size()>1) {
                    ArrayList<Integer> backwardIndicesNew = new ArrayList<Integer>();
                    ArrayList<Integer> backwardOccurancesNew = new ArrayList<Integer>();
                    boolean allInOrder = true;
                    //order for elements that gets pushed backward 
                    for (int i=0; i<backwardIndices.size(); i++) { 
                        final int origTag = backwardIndices.get(i);
                        boolean notForward = true;
                        for (int j=1; j<=Math.min(i,2) ; j++) {
                            if (origTag==backwardOccurances.get(i-j)) {
                                count+=j;
                                notForward = false;
                                
                                break;
                            }
                        }
                        allInOrder=allInOrder && notForward; 
                        if (notForward) {
                            backwardIndicesNew.add(Integer.valueOf(backwardIndices.get(i)));
                        }
                        if (origTag>=backwardOccurances.get(i)) {
                            backwardOccurancesNew.add(Integer.valueOf(backwardOccurances.get(i)));
                        }
                    }
                    if (allInOrder) {
                        break;
                    }
                    backwardIndices=backwardIndicesNew;
                    backwardOccurances=backwardOccurancesNew;
                    //System.out.println(Arrays.toString(backwardIndices.toArray()));
                    //System.out.println(Arrays.toString(backwardOccurances.toArray()));
                    assert backwardIndices.size()==backwardOccurances.size();
                }
                System.out.println(count);   
            }
        }
    }
}
