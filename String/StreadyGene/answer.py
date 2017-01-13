size=int(input())
gene=input()
steady=size//4

strCounts={"A":0, "T":0,"G":0,"C":0}
for x in gene:
    strCounts[x]+=1
exCounts={"A":strCounts['A']-steady, "T":strCounts['T']-steady,"G":strCounts['G']-steady,"C":strCounts['C']-steady}

#print(steady, strCounts, exCounts)

t=size
h=0
substrCounts={"A":0, "T":0,"G":0,"C":0}

def validSubstr(substrCounts):
    return substrCounts['A']>=exCounts['A'] and substrCounts['T']>=exCounts['T'] and substrCounts['G']>=exCounts['G'] and substrCounts['C']>=exCounts['C']

#Find the first tail
for i in range(0, size):
    #print("--", substrCounts)
    if validSubstr(substrCounts):
        #print("--", substrCounts)
        t=i
        break
    substrCounts[gene[i]]+=1
#print(t)

#Find the first head
h=0
for i in range(0, t):
    #print("==", substrCounts)
    substrCounts[gene[i]]-=1
    if validSubstr(substrCounts):
        #print("==++", substrCounts)
        h=i+1
    else:
        substrCounts[gene[i]]+=1
        break
        
#print(h)


minsubstringsize=t-h
#print(minsubstringsize)
#Now we have the leftmost match,
#Move the windows to the right
while True:
    #Shrink the window head
    # We find the smallest window given a fixed tail
    while h<t:
        substrCounts[gene[h]]-=1
        h+=1
        if validSubstr(substrCounts):
            #print("++1", h,t)
            minsubstringsize = min(minsubstringsize, t-h)
        else:
            break
    # If we cannot move the tail to the right, we've already found all all the windows possible. Break the loop
    if minsubstringsize<2 or t>=size:
        break
    # Try to move the tail to the right, 
    # until we find a valid one, or t is outside the string, or the window size is larger than previous min window size
    while not validSubstr(substrCounts) and t-h<minsubstringsize and t!=size:
        #print("++2", h,t)
        substrCounts[gene[t]]+=1
        t+=1
    

#print("h=", h)
#print("t=", t)
print(minsubstringsize)


