def solution(n, results):
    answer = 0
    graph = [[2] * n for _ in range(n)]
    for result in results:
        a, b = result
        graph[a-1][b-1] = 1
        graph[b-1][a-1] = -1
    
    for i in range(n):
        graph[i][i] = 0
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if graph[i][k] == 1 and graph[k][j] == 1:
                    graph[i][j] = 1
                    graph[j][i] = -1
                    
    for g in graph:
        if 2 not in g:
            answer += 1
    
    return answer
