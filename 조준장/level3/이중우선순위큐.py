import heapq

def solution(operations):
    heap = []
    
    for operation in operations:
        o, num = operation.split()
        num = int(num)
        
        if o == "I":
            heapq.heappush(heap, num)
        
        elif heap:
            if num == -1:
                heapq.heappop(heap)
            else:
                heap.remove(max(heap))
                heapq.heapify(heap)
                
    if not len(heap):
        return [0, 0]

    return [max(heap), heap[0]]
