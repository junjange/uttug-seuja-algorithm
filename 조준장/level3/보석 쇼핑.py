from collections import defaultdict


def solution(gems):
    answer = []
    start_idx = 0
    gems_num = len(set(gems))
    gems_dict = defaultdict(int)   
    
    for end_idx in range(len(gems)):
        gems_dict[gems[end_idx]] += 1

        while len(gems_dict) >= gems_num:
            answer.append([end_idx - start_idx, start_idx, end_idx])
            gems_dict[gems[start_idx]] -= 1
            
            if not gems_dict[gems[start_idx]]:
                del gems_dict[gems[start_idx]]
            
            start_idx += 1
    
    answer.sort(key=lambda x : (x[0]))
    
    return [answer[0][1]+1, answer[0][2]+1]
