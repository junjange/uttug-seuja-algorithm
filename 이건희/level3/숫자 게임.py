import heapq

def solution(A, B):
    result = 0
    heapq.heapify(A), heapq.heapify(B)
    
    while B:
        if A[0] < B[0]:
            result += 1
            heapq.heappop(A), heapq.heappop(B)
        else:
            heapq.heappop(B)
            
    return result
