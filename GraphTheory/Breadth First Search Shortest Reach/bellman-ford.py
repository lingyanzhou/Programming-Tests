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
    connectUpdatedMap = [[False for x in range(nodeCount)] for y in range(nodeCount)]
    
    for j in range(0, edgeCount):
        (s, n) = [int(x) for x in input().split(" ")]
        connectMap[s-1][n-1]=6
        connectMap[n-1][s-1]=6
        connectUpdatedMap[s-1][n-1]=True
        connectUpdatedMap[n-1][s-1]=True
    start = int(input())-1
    
    for j in range(0, edgeCount):
        connectUpdatedMapNew = [[False for x in range(nodeCount)] for y in range(nodeCount)]
        changed=False
        for k in range(0, nodeCount-1):
            for k2 in range(k+1, nodeCount):
                for k3 in range(0, nodeCount):
                    
                    if k==k3 or k2==k3 or (not (connectUpdatedMap[k][k2] or connectUpdatedMap[k2][k3])):
                        continue
                    else:
                        val = chooseMinRoute(connectMap, k, k2, k3)
                        continue
                        if val!=connectMap[k][k2]:
                            connectMap[k][k2]=val
                            connectMap[k2][k]=val
                            connectUpdatedMapNew[k][k2]=True
                            connectUpdatedMapNew[k2][k]=True
                            changed=True

        if not changed:
            break
        
        connectUpdatedMap=connectUpdatedMapNew

    for j in range(0, nodeCount):
        if j!=start:
            print(connectMap[start][j], end=" ")
    print()

