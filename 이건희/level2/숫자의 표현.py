def solution(n):
    result = 1
    cnt = 0
    num = n // 2 + 1
    
    for i in range(1, num):
        for j in range(i, num + 1):
            cnt += j
            if cnt == n:
                result += 1
                cnt = 0
            elif cnt > n:
                cnt = 0
                break
            
    return result
