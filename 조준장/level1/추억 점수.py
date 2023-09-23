def solution(name, yearning, photo):
    answer = []
    dic = {}
    for i in range(len(name)):
        dic[name[i]] = yearning[i]
    
    for p in photo:
        new_answer = 0
        for k in p:
            if k in dic:
                new_answer += dic[k]
        answer.append(new_answer)
            
    return answer
