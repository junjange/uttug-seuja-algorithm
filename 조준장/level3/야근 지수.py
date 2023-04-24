import heapq

def solution(n, works):
    
    if n >= sum(works):
        return 0
    
    heap = []
    for work in works:
        heapq.heappush(heap, (-work, work))
    
    for i in range(n):
        target = heap[0][1] - 1
        heapq.heappop(heap)
        heapq.heappush(heap, (-target, target))
            
    return sum([h[1] ** 2 for h in heap])
    
