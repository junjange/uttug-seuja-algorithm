def solution(lottos, win_nums):
    answer = []
    grade=7
    for i in lottos:
        if i in win_nums:
            grade-=1
                
    answer.append(grade)
    p=lottos.count(0)
    answer.insert(0,grade-p)
    if answer[0]==7:
        answer[0]=6
    if answer[1]==7:
        answer[1]=6    
    return answer
