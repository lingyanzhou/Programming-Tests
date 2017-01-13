import math

def calcKmp(S):
    kmp=[0 for x in S]
    kmp[0] = 0
    for i in range(1, len(S)):
        k = kmp[i - 1]
        while k > 0 and S[i] != S[k] :
            k = kmp[k-1]
        if S[i] == S[k] :
            kmp[i] = k +1
        else :
            kmp[i] = 0
    return kmp


def testKmp(length, options) :
	tests=[0 for x in range(0,length)]
	
	for i in range(0, options**length):
		tests=[0 for x in range(0,length)]
		value=i
		digit=0
		while value!=0:
			tests[digit]=value%options
			digit+=1
			value=value//options
		print("".join([chr(x+97) for x in tests]))
		print(calcKmp(tests))
		print(sum(calcKmp(tests)))


####INPUT####
#############

#freqs=[int(x) for x in input().split(" ")]

freqs=[int(x) for x in "43 34 38 53 32 30 39 40 52 31 37 37 32 38 45 33 56 39 34 35 39 38 34 31 46 34".split(" ")]
freqs=[int(x) for x in "2 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0".split(" ")]
#############

minCharFreq=freqs[0]
minCharIndex=0
for i in range(0, 26):
	if freqs[i]>0 and (minCharFreq>freqs[i] or minCharFreq==0):
		minCharFreq=freqs[i]
		minCharIndex=i
result=[]

if freqs[minCharIndex]>0:
	result.append(minCharIndex)
	freqs[minCharIndex]-=1
hasPrevChars = False
for i in range(0, minCharIndex):
	for j in range(0, freqs[i]):
		result.append(i)
		hasPrevChars=True

if not hasPrevChars:
	while freqs[minCharIndex]>0:
		result.append(minCharIndex)
		freqs[minCharIndex]-=1
		for i in range(minCharIndex+1, 26):
			if freqs[i]>0:
				result.append(i)
				freqs[i]-=1
				break
else:
	while freqs[minCharIndex]>0:
		result.append(minCharIndex)
		freqs[minCharIndex]-=1
for i in range(minCharIndex+1, 26):
	for j in range(0,freqs[i]):
		result.append(i)
	freqs[i]=0
	
resultStr = "".join([chr(x+97) for x in result])
print(resultStr)
#print(calcKmp(result))
