import copy

def dfs(v, graph, visited):
    for i in graph[v]:
        if not visited[i]:
            visited[i] = True
            dfs(i, graph, visited)
    return visited
        

def solution(n, wires):
    answer = 1e9
    for i in range(len(wires)):
        new_wires = copy.deepcopy(wires)
        graph = [[] for _ in range(n+1)]
        visited = [False for _ in range(n+1)]
        new_wires.pop(i)

        for w in new_wires:
            a, b = w
            graph[a].append(b)
            graph[b].append(a)
        visited[i+1] = True
        visited = dfs(i+1, graph, visited)
        answer = min(answer, abs(visited.count(False) - visited.count(True)-1))        
    return answer
