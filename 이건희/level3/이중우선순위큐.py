import heapq

def solution(operations):
    result = []
    
    for i in operations:
        if i == "D 1":
            if len(result) == 0:
                continue
            result.remove(max(result))
            heapq.heapify(result)
        elif i == "D -1":
            if len(result) == 0:
                continue
            heapq.heappop(result)
        else:
            num = int(i.split(' ')[1])
            heapq.heappush(result, num)
    
    result = list(result)
    
    return [max(result), min(result)] if result else [0, 0]
