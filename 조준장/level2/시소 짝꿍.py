from collections import defaultdict


def solution(weights):
    answer = 0
    seesaw = defaultdict(int)

    for w in weights:
        answer += seesaw[w]
        answer += seesaw[(w * 2) / 3] 
        answer += seesaw[(w * 3) / 2]
        answer += seesaw[(w * 3) / 4] 
        answer += seesaw[(w * 4) / 3]
        answer += seesaw[(w * 4) / 2] 
        answer += seesaw[(w * 2) / 4]
        seesaw[w] += 1

    return answer
