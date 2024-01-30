import sys
sys.setrecursionlimit(8 * 10 ** 7)

def dfs(start, new_graph, visited):
    if visited[start]:
        return

    visited[start] = True
    for g in new_graph[start]:
        dfs(g, new_graph, visited)

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
reversed_graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, t = map(int, sys.stdin.readline().split())
    graph[s].append(t)
    reversed_graph[t].append(s)
s, t = map(int, sys.stdin.readline().split())

from_s = [False for _ in range(n + 1)]
from_s[t] = True
dfs(s, graph, from_s)

from_t = [False for _ in range(n + 1)]
from_t[s] = True
dfs(t, graph, from_t)

to_s = [False for _ in range(n + 1)]
dfs(s, reversed_graph, to_s)

to_t = [False for _ in range(n + 1)]
dfs(t, reversed_graph, to_t)

answer = 0
for i in range(1, n + 1):
    if from_s[i] and from_t[i] and to_s[i] and to_t[i]:
        answer += 1
        
print(answer - 2)
        
