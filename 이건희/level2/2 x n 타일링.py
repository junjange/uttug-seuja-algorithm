def solution(n):
    num1 = 1
    num2 = 2
    cnt = 0
    
    for i in range(2, n):
        cnt = num1 + num2
        num1 = num2
        num2 = cnt
        
    return cnt % 1000000007
