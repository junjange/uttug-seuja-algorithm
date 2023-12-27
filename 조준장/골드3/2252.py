"""
- 위상정렬
"""
import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
visited = [0 for _ in range(n + 1)]
queue = deque([])
answer = []

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    visited[b] += 1

for i in range(1, n + 1):
    if visited[i] == 0:
        queue.append(i)

while queue:
    target = queue.pop()
    answer.append(target)

    for i in graph[target]:
        visited[i] -= 1
        if visited[i] == 0:
            queue.append(i)
print(*answer)
