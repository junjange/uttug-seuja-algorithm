def solution(skill, skill_trees):
    result = 0
    
    for i in skill_trees:
        order = ''
        
        for j in i:
            if j in skill:
                order += j
                
        if order == skill[:len(order)]:
            result += 1
            
    return result
