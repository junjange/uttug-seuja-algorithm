import sys
import heapq


def dijkstra(s):
    heap = [[0, s]]
    visited[s] = 0

    while heap:
        level, index = heapq.heappop(heap)

        for g in graph[index]:
            new_level = max(level, g[1])
            new_index = g[0]

            if new_level < visited[new_index]:
                visited[new_index] = new_level
                heapq.heappush(heap, [new_level, new_index])


n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append([b, c])
    graph[b].append([a, c])


visited = [int(1e9) for i in range(n + 1)]

dijkstra(1)

for i in range(visited[n] + 1, visited[n] * 2):
    if i % 2 == 0:
        continue
    flag = True
    for j in range(2, int(i ** 0.5) + 1):
        if i % j == 0:
            flag = False
            break
    if flag:
        print(i)
        break
