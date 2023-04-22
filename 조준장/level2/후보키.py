from itertools import combinations

def solution(relation):
    answer = []
    row = len(relation)
    colum = len(relation[0])
    combi = []
    for i in range(1, colum+1):
         combi += combinations(range(colum), i)   
            
    for c in combi:
        key = [tuple([item[key] for key in c]) for item in relation]
        if len(set(key)) == row:
            flag = True
            for a in answer:
                if set(a).issubset(set(c)):  
                    flag = False
                    break
            if flag:
                answer.append(c)
            
    return len(answer)
