from heapq import heappush, heappop

def solution(n, k, enemy):
    heap = []
    
    for i, damage in enumerate(enemy):
        heappush(heap, damage)
        
        if len(heap) > k:
            n -= heappop(heap)
        
        if n < 0:
            return i
        
    return len(enemy)
