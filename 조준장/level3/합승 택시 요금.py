import heapq

def bfs(n, graph, start):
    visited = [1e9 for _ in range(n+1)]
    visited[start] = 0
    heap = [] 
    heapq.heappush(heap, start)
    
    while heap:
        new_start = heapq.heappop(heap)

        for ns, np in graph[new_start]:
            if visited[ns] > visited[new_start] + np:
                visited[ns] = visited[new_start] + np
                heapq.heappush(heap, ns)

    return visited
    
    

def solution(n, s, a, b, fares):
    answer = 1e9
    graph = [[] for _ in range(n+1)]
    
    for fare in fares:
        c, d, f = fare
        graph[c].append([d, f])
        graph[d].append([c, f])
    
    dist = [[]]
    for i in range(1, n+1):
        dist.append(bfs(n, graph, i))
    
    for i in range(1, n+1):
        answer = min(answer, dist[s][i] + dist[i][a] + dist[i][b])
    return answer
