####INPUT####
#############

#caseCount=int(input())
#cases=[input() for x in range(0,caseCount)]


caseCount=10
cases='''dbcfibibcheigfccacfegicigcefieeeeegcghggdheichgafhdigffgifidfbeaccadabecbdcgieaffbigffcecahafcafhcdg
dfcaabeaeeabfffcdbbfaffadcacdeeabcadabfdefcfcbbacadaeafcfceeedacbafdebbffcecdbfebdbfdbdecbfbadddbcec
gjjkaaakklheghidclhaaeggllagkmblhdlmihmgkjhkkfcjaekckaafgabfclmgahmdebjekaedhaiikdjmfbmfbdlcafamjbfe
fdbdidhaiqbggqkhdmqhmemgljaphocpaacdohnokfqmlpmiioedpnjhphmjjnjlpihmpodgkmookedkehfaceklbljcjglncfal
bcgdehhbcefeeadchgaheddegbiihehcbbdffiiiifgibhfbchffcaiabbbcceabehhiffggghbafabbaaebgediafabafdicdhg
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
mhmgmbbccbbaffhbncgndbffkjbhmkfncmihhdhcebmchnfacdigflhhbekhfejblegakjjiejeenibemfmkfjbkkmlichlkbnhc
fdacbaeacbdbaaacafdfbbdcefadgfcagdfcgbgeafbfbggdedfbdefdbgbefcgdababafgffedbefdecbaabdaafggceffbacgb
bahdcafcdadbdgagdddcidaaicggcfdbfeeeghiibbdhabdhffddhffcdccfdddhgiceciffhgdibfdacbidgagdadhdceibbbcc
dichcagakdajjhhdhegiifiiggjebejejciaabbifkcbdeigajhgfcfdgekfajbcdifikafkgjjjfefkdbeicgiccgkjheeiefje'''.split('\n')
#############
    

def isAnagram(str1, str2):
    if len(str1)!=len(str2):
        return False
    alphaFreq1 = getAlphaFreq(str1)
    alphaFreq2 = getAlphaFreq(str2)
    
    return alphaFreq1==alphaFreq2;
    

def getAlphaFreq(string):
    ret = [0]*26
    for x in string:
        ret[ord(x)-97]+=1
    return ret
    
def addToAlphaFreq(char, freq):
    freq[ord(char)-97]+=1
    return freq


def findAnagramCount(string):
    return findAnagramCountHelper(string, 0, [])

def findAnagramCountHelper(string, level, alphaFreqs):
    result = 0
    if len(string)<=level+1 or level<0:
        return 0
    alphaFreqsNew=None
    substrLen = level+1
    if level==0:
        alphaFreqsNew=[0]*len(string)
        for i in range(0, len(string)):
            alphaFreqsNew[i]=getAlphaFreq(string[i])
    else:
        substrLen = level+1
        alphaFreqsNew=[0]*(len(string)-substrLen+1)
        for i in range(0, (len(string)-substrLen+1)):
            alphaFreqsNew[i]=addToAlphaFreq( string[i+substrLen-1], alphaFreqs[i])
        
    for ind in range(0, len(string)-substrLen):
        for ind2 in range(ind+1, len(string)-substrLen+1):
            if alphaFreqsNew[ind]==alphaFreqsNew[ind2]:
                result+=1
    return result+findAnagramCountHelper(string, level+1, alphaFreqsNew)

def main(cases):
    for case in cases:
        count = findAnagramCount(case)
        print(count)

main(cases)
