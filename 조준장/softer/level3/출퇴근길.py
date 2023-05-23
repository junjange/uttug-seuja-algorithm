import sys


def dfs(now, graph, visited):
    if visited[now]:
        return
    
    visited[now] = True 
    for i in graph[now]:
        dfs(i, graph, visited)

    return
    
n, m = map(int,sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
graph_reverse = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph_reverse[b].append(a)

s, t = map(int,sys.stdin.readline().split())

visited_s = [False] * (n+1)
visited_s[t] = True
dfs(s, graph, visited_s)

visited_t = [False] * (n+1)
visited_t[s] = True
dfs(t, graph, visited_t)

visited_reverse_s = [False] * (n+1)
dfs(s, graph_reverse, visited_reverse_s)

visited_reverse_t = [False] * (n+1)
dfs(t, graph_reverse, visited_reverse_t)


print(sum([1 for i in range(1, n+1) if visited_s[i] and visited_t[i] and visited_reverse_s[i] and visited_reverse_t[i]]) - 2)
