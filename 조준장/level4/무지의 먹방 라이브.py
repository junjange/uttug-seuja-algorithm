import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    heap = []
    for i in range(len(food_times)):
        heapq.heappush(heap, [food_times[i], i+1])
    
    eaten = 0
    while heap:
        target = heapq.heappop(heap)
        time = (target[0] - eaten) * (len(heap) + 1)
        if time <= k:
            k -= time
            eaten = target[0]
        
        else:
            heapq.heappush(heap, target)
            idx = k % len(heap)
            heap.sort(key=lambda x: x[1])
            return heap[idx][1]
        
    return 1
