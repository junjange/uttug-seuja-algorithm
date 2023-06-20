import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    result = 0
    
    while True:
        first = heapq.heappop(scoville) 
        if first >= K:
            break
        if len(scoville) == 0:
            return -1
        second =  heapq.heappop(scoville)
        num = first + second * 2
        heapq.heappush(scoville, num)
        result += 1
        
    return result
