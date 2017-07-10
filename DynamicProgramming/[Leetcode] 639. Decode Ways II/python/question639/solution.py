import numpy as np

class Solution:
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        TO_MOD = 10**9+7
        
        prevRes = 1
        prevPrevRes = 0
        prevCh = None
        try:
            for ch in s :
                if prevCh==None:
                    if ch=='*':
                        prevPrevRes = 1
                        prevRes = 9
                    elif ch=='0':
                        raise "Wrong Input"
                    else:
                        prevPrevRes=1
                        prevRes=1
                elif prevCh=='0':
                    if ch=='*':
                        prevPrevRes, prevRes=prevRes, 9*prevRes
                    elif ch=='0':
                        raise "Wrong Input"
                    else:
                        prevPrevRes, prevRes=prevRes, prevRes
                elif prevCh=='*':
                    if ch=='*':
                        prevPrevRes, prevRes = prevRes, (prevRes*9+prevPrevRes*15)%TO_MOD
                    elif ch=='0':
                        prevPrevRes, prevRes = prevRes, (prevPrevRes*2)%TO_MOD
                    elif int(ch)<=6:
                        prevPrevRes, prevRes = prevRes, (prevRes+prevPrevRes*2)%TO_MOD
                    else:
                        prevPrevRes, prevRes = prevRes, (prevRes+prevPrevRes)%TO_MOD
                elif prevCh=='1':
                    if ch=='*':
                        prevPrevRes, prevRes = prevRes, (prevPrevRes*9+prevRes*9)%TO_MOD
                    elif ch=='0':
                        prevPrevRes, prevRes = prevRes, prevPrevRes
                    else:
                        prevPrevRes, prevRes = prevRes, prevRes+prevPrevRes
                elif prevCh=='2':
                    if ch=='*':
                        prevPrevRes, prevRes = prevRes, (prevPrevRes*6+prevRes*9)%TO_MOD
                    elif ch=='0':
                        prevPrevRes, prevRes = prevRes, prevPrevRes
                    else:
                        tmp = int(prevCh+ch)
                        if tmp<=26:
                            prevPrevRes, prevRes = prevRes, (prevRes+prevPrevRes)%TO_MOD
                        else:
                            prevPrevRes, prevRes = prevRes, prevRes
                else:
                    if ch=='*':
                        prevPrevRes, prevRes = prevRes, (prevRes*9)%TO_MOD
                    elif ch=='0':
                        raise "Wrong Input"
                    else:
                        prevPrevRes, prevRes = prevRes, prevRes
                prevCh = ch

            return prevRes%TO_MOD
        except:
            return 0
