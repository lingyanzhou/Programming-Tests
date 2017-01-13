def answer(chunk, word):
    # your code here
    visited = set()
    candidates = answer_helper(chunk, word, visited)
    lexSortedCandidates = sorted(candidates)
    lenLexSortedCandidates = sorted(lexSortedCandidates, key=lambda candidate:len(candidate))
    return lenLexSortedCandidates[0]

def answer_helper(chunk, word, visited):
    word_length = len(word)
    chunk_length = len(chunk)
    start_index = chunk.find(word)
    ret = set()
    if -1==start_index:
        ret.add(chunk)
        return ret

    while -1!=start_index:
        step_result = ""
        if start_index!=0:
            step_result += chunk[0:start_index]
        tmpIndex = start_index+word_length
        if tmpIndex<chunk_length:
            step_result += chunk[tmpIndex:]
        if (step_result in visited):
            pass
        else:
            visited.add(step_result)
            ret.update(answer_helper(step_result, word, visited))
        start_index = chunk.find(word, start_index+1)
    return ret

def testAnswer():
    a = answer("goodgooogoogfogoood", "goo")
    e = "dogfood"
    print "Answer = ", a
    print "Expected = ", e
    print a==e

    a = answer("lololololo", "lol")
    e = "looo"
    print "Answer = ", a
    print "Expected = ", e
    print a==e

    a = answer("lololololol", "lol")
    e = "oo"
    print "Answer = ", a
    print "Expected = ", e
    print a==e


if __name__ == "__main__":
    testAnswer()

