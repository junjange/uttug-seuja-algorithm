import sys
import heapq

n, m = map(int, sys.stdin.readline().split(" "))
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split(" "))
    graph[a].append([b, c])
    graph[b].append([a, c])

heap = []
heapq.heappush(heap, [1, 0])
visited = [1e9] * (n + 1)
visited[1] = 0

while heap:
    ta, tc = heapq.heappop(heap)

    for a_i, c_i in graph[ta]:
        cost = tc + c_i
        if cost < visited[a_i]:
            visited[a_i] = cost
            heapq.heappush(heap, [a_i, cost])

print(visited[n])
