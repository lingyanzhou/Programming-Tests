package lzhou.programmingtest.geeksforgeeks.the_celebrity_problem;

import java.util.*;

/**
 * Idea: 
 * 1. From k people, we can select one candidate, an eliminate all others.
 * 2. A candidate does not have outbound linkes, and it has all links from the others.
 * 3. If a candidate has out bound links, then it is eliminated, and we move on to the next person.
 * 4. After processing all people, we verify the candidate, it should have no outbound, and should have inbound links from all others.
 */
public class Solution
{
    int getId(int M[][], int n)
    {
        // Your code here
        int candidate=0;
        int question = 0;
        for (; candidate<n && question<n; ++candidate) {
            for (;question<n; ++question) {
                if (M[candidate][question]==1) {
                    break;
                }
            }
        }
        candidate -= 1;
        for (int i=0; i<n; ++i) {
            if (M[candidate][i]==1) {
                return -1;
            }
        }
        for (int i=0; i<n; ++i) {
            if (i!=candidate && M[i][candidate]==0) {
                return -1;
            }
        }
        return candidate;
    }
}
