from itertools import permutations

def isCheck(P, banned_id):
    for i in range(len(P)):
        if len(P[i]) != len(banned_id[i]):
            return False
        
        for j in range(len(P[i])):
            if banned_id[i][j] == "*":
                continue
            if P[i][j] != banned_id[i][j]:
                return False
    return True
        

def solution(user_id, banned_id):
    answer = []
    for P in permutations(user_id, len(banned_id)):
        if isCheck(P, banned_id):
            sp = set(P)
            if sp not in answer:
                answer.append(sp)
    return len(answer)
