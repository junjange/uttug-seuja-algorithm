def solution(participant, completion):
    hashDict = {}
    result = 0

    for i in participant:
        hashDict[hash(i)] = i
        result += hash(i)

    for i in completion:
        result -= hash(i)

    return hashDict[result]
