import heapq

def solution(n, works):
    if sum(works) <= n:
        return 0
    
    works = [-1 * i for i in works]
    heapq.heapify(works)

    for _ in range(n):
        num = heapq.heappop(works)
        heapq.heappush(works, num + 1)
        
    return sum([i ** 2 for i in works])
