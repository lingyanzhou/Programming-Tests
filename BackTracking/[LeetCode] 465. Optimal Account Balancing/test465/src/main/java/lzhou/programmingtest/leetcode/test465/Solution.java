package lzhou.programmingtest.leetcode.test465;

import java.util.*;

public class Solution 
{
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> accounts = new HashMap<Integer, Integer>();
        for (int[] trans: transactions) {
            accounts.put(trans[0], 0);
            accounts.put(trans[1], 0);
        }
        for (int[] trans: transactions) {
            accounts.put(trans[0], accounts.get(trans[0])-trans[2]);
            accounts.put(trans[1], accounts.get(trans[1])+trans[2]);
        }

        Set<Integer> posAccount = new HashSet<Integer>();
        Set<Integer> negAccount = new HashSet<Integer>();

        for (Integer key: accounts.keySet()) {
            if (accounts.get(key)>0) {
                posAccount.add(key);
            } else if (accounts.get(key)<0) {
                negAccount.add(key);
            }
        }

        return minTransfersHelper(accounts, posAccount, negAccount);
    }
    
    private int minTransfersHelper(Map<Integer, Integer> accounts, Set<Integer> posAccount, Set<Integer> negAccount) {
        int ret = Integer.MAX_VALUE;

        for (Integer p : posAccount) {
            if (accounts.get(p)==0) {
                continue;
            }
            for (Integer n: negAccount) {
                if (accounts.get(n)==0) {
                    continue;
                }
                int tmp = accounts.get(p)+accounts.get(n);
                if (tmp<0) {
                    int oldN = accounts.get(n);
                    int oldP = accounts.get(p);
                    accounts.put(n, tmp);
                    accounts.put(p, 0);
                    ret = Math.min(ret, 1+minTransfersHelper(accounts, posAccount, negAccount));
                    accounts.put(n, oldN);
                    accounts.put(p, oldP);
                } else if (tmp>0) {
                    int oldN = accounts.get(n);
                    int oldP = accounts.get(p);
                    accounts.put(n, 0);
                    accounts.put(p, tmp);
                    ret = Math.min(ret, 1+minTransfersHelper(accounts, posAccount, negAccount));
                    accounts.put(n, oldN);
                    accounts.put(p, oldP);
                } else {
                    int oldN = accounts.get(n);
                    int oldP = accounts.get(p);
                    accounts.put(n, 0);
                    accounts.put(p, 0);
                    ret = Math.min(ret, 1+minTransfersHelper(accounts, posAccount, negAccount));
                    accounts.put(n, oldN);
                    accounts.put(p, oldP);
                }
            }
        }

        if (ret==Integer.MAX_VALUE) {
            ret = 0;
        }
        return ret;
    }
}
