import numpy as np
class Solution:
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        allElms = []
        allElms.append(np.zeros(len(needs)+1))
        for sp in special:
            newElms = []
            for l in allElms:
                for i in range(1,7):
                    tmp = np.asarray(l)+np.asarray(sp)*i
                    if any(tmp[:-1]>needs):
                        break
                    else:
                        newElms.append(tmp)
            allElms = allElms+newElms
        allElms = list(map(lambda x: self.calcPrice(x,price, needs), allElms))
        minPrice = min(list(map(lambda x: x[-1], allElms)))
        return (int(minPrice))
                       
    def calcPrice(self, arr, price, needs):
        p = sum((np.asarray(needs)-arr[:-1])*np.asarray(price))+arr[-1]
        arr[-1]=p
        return arr
