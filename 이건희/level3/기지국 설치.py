import heapq
import math

def solution(n, stations, w):
    result = 0
    now = 1
    ran = w * 2 + 1
    heapq.heapify(stations)
    
    while stations:
        num = heapq.heappop(stations)
        s = num - w
        if s > now:
            lenght = s - now
            result += math.ceil(lenght / ran)
        now = num + w + 1
        
        if now > n:
            break
        
    if now <= n:
        lenght = n - now + 1
        result += math.ceil(lenght / ran)        
    return result
