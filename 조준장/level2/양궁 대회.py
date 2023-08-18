def info_calculate(info, target):
    point = 0
    for i in range(len(info)):
        if info[i] == 0 and target[i] == 0: 
            continue 
        if info[i] < target[i]:
            point += (10 - i) 
        else:
            point -= (10 - i) 
    return point


def backtracking(info, result, start, n):
    global answer
    if n == 0 or start == 11:
        if n :
            result[-1] = n

        if info_calculate(info, answer) < info_calculate(info, result):
            answer = result[::]
        elif info_calculate(info, answer) == info_calculate(info, result):
            for i in range(11):
                if answer[10-i] < result[10-i]:
                    answer = result[::]
                    break
                elif answer[10-i] > result[10-i]:
                    break
        return
    
    for i in range(start, 11):
        if info[i] < n:
            result[i] = info[i] + 1
            backtracking(info, result, i+1, n-(info[i]+1))
            result[i] = 0
        
        elif i == 10:
            backtracking(info, result, i+1, n)
            result[-1] = 0

answer = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
def solution(n, info):
    backtracking(info, [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 0, n)
    if info_calculate(info, answer) <= 0:
        return [-1]
    return answer
