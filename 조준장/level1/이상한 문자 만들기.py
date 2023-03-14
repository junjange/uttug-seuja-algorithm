def solution(s):
    answer = ''
    s = s.split(" ")
    for s_sprit in s:
        for i in range(len(s_sprit)):
            
            if s_sprit[i] == "":
                answer += " "
                continue
                
            if i % 2 == 0:
                answer += s_sprit[i].upper()
            else:
                answer += s_sprit[i].lower()
        
        answer += " "
    
    return answer[:-1]
