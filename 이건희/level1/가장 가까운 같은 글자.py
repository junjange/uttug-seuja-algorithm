def solution(s):
    result = []
    dic = dict()
    for i in range(len(s)):
        if s[i] not in dic:
            result.append(-1)
        else:
            result.append(i - dic[s[i]])
        dic[s[i]] = i

    return result
