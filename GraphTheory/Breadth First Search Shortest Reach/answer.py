def distanceAdd(a, b):
    if a==-1 or b==-1:
        return -1
    else:
        return a+b

def distanceLessThan(a, b):
    if a==-1:
        return b==-1
    elif b==-1:
        return True
    else:
        return a<b

def minDistance(a, b):
    if a==-1:
        return b
    elif b==-1:
        return a
    else:
        return min(a, b)
    
def chooseMinRoute(connectMap, start, end, via):
    if (distanceLessThan(connectMap[start][via], connectMap[start][end])
        and distanceLessThan(connectMap[via][end], connectMap[start][end])):
        return minDistance(connectMap[start][end], distanceAdd(connectMap[start][via], connectMap[via][end]))
    return connectMap[start][end]


testCount=int(input())
for i in range(0,testCount):
    (nodeCount, edgeCount) = [int(x) for x in input().split(" ")]
    connectMap = [[-1 for x in range(nodeCount)] for y in range(nodeCount)] 

    resultArr = [-1 for x in range(nodeCount)]
    visited = []
    notVisited = [i for i in range(nodeCount)]
    newlyVisited = []
    
    for j in range(0, edgeCount):
        (s, n) = [int(x) for x in input().split(" ")]
        connectMap[s-1][n-1]=6
        connectMap[n-1][s-1]=6
    start = int(input())-1
    
    notVisited.remove(start)

    for k in list(notVisited):
        if connectMap[start][k]!=-1:
            newlyVisited.append(k)
            notVisited.remove(k)
            resultArr[k]=connectMap[start][k]
    
    while len(newlyVisited)>0:
        prevVisited = list(newlyVisited)
        newlyVisited.clear()
        while len(prevVisited)>0:
            j = prevVisited.pop()
            for k in list(notVisited):
                if connectMap[j][k]!=-1:
                    newlyVisited.append(k)
                    notVisited.remove(k)
                    resultArr[k]=resultArr[j]+connectMap[j][k]
                
        

    for j in range(0, nodeCount):
        if j!=start:
            print(resultArr[j], end=" ")
    print()


