def solution(N, road, K):
    result = 0
    graph = [[10 ** 9] * (N+1) for _ in range(N+1)]

    for i in range(N + 1):
        graph[i][i] = 0
        
    for i in road:
        graph[i[0]][i[1]] = min(graph[i[0]][i[1]], i[2])
        graph[i[1]][i[0]] = min(graph[i[1]][i[0]], i[2])

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            for k in range(1, N + 1):
                graph[j][k] = min(graph[j][i] + graph[k][i], graph[j][k])

    return len([d for d in graph[1] if d <= K])
