def solution(A, B):
    answer = 0
    n = len(A)
    A.sort()
    B.sort()
    idx = 0
    
    for i in range(n):
        if A[idx] < B[i]:
            answer += 1
            idx+=1

    return answer
