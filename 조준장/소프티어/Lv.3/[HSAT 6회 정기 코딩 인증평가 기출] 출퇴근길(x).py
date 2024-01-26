import sys
sys.setrecursionlimit(8 * 10 ** 7)

def bfs(now, visited, new_graph):
    if visited[now] == 1:
        return
    else:
        visited[now] = 1
        for nx in new_graph[now]:
            bfs(nx, visited, new_graph)
    return

n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
reverse_graph = [[] for _ in range(n + 1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    reverse_graph[b].append(a)

s, t = map(int, sys.stdin.readline().split())
answer = 0

fromS = [0] * (n + 1)
fromS[t] = 1
bfs(s, fromS, graph)

fromT = [0] * (n + 1)
fromT[s] = 1
bfs(t, fromT, graph)

toS = [0] * (n + 1)
bfs(s, toS, reverse_graph)

toT = [0] * (n + 1)
bfs(t, toT, reverse_graph)

for i in range(1, n + 1):
    if fromS[i] and fromT[i] and toS[i] and toT[i]:
        answer += 1
print(answer - 2)

        
