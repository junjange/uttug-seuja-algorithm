def solution(s):
    answer = []
    for i in range(len(s)):
        for j in range(i, len(s)):
            if s[i:j+1] == s[i:j+1][::-1]:
                answer.append(len(s[i:j+1]))
    return max(answer)
