import heapq
from collections import defaultdict

def solution(n, roads, sources, destination):
    answer = defaultdict()
    for s in sources:
        answer[s] = -1
        
    graph = [[] for _ in range(n+1)]
    for road in roads:
        x, y = road
        graph[x].append(y)
        graph[y].append(x)
        
    visited = [False] * (n+1)
    visited[destination] = True
    
    heap = []
    heapq.heappush(heap, [0, destination])
        
    while heap:
        depth, target = heapq.heappop(heap)
        if target in sources:
            answer[target] = depth
            
        for i in graph[target]:
            if not visited[i]:
                visited[i] = True
                heapq.heappush(heap, [depth+1, i])
        
    return list(answer.values())
