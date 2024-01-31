import sys


n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

score = [[0] * n for _ in range(n)] 
visited = [[0] * n for _ in range(n)] 
visited[0][0] = graph[0][0]

for i in range(n):
    for j in range(n):
        if i == 0 and j == 0:
            continue
            
        if i == 0:
            visited[i][j] = max(graph[i][j], visited[i][j - 1])
            graph[i][j] += graph[i][j - 1]

        elif j == 0:
            visited[i][j] = max(graph[i][j], visited[i - 1][j])
            graph[i][j] += graph[i - 1][j]

        else:
            if score[i][j - 1] < score[i - 1][j]:
                visited[i][j] = max(graph[i][j], visited[i - 1][j])
                graph[i][j] += graph[i - 1][j]
            elif score[i][j - 1] > score[i - 1][j]:
                visited[i][j] = max(graph[i][j], visited[i][j - 1])
                graph[i][j] += graph[i][j - 1]

            else:
                if visited[i][j - 1] < visited[i - 1][j]:
                    visited[i][j] = max(graph[i][j], visited[i - 1][j])
                    graph[i][j] += graph[i - 1][j]
                else:
                    visited[i][j] = max(graph[i][j], visited[i][j - 1])
                    graph[i][j] += graph[i][j - 1]
            
        score[i][j] = graph[i][j] + visited[i][j]
        
print(score[n-1][n-1])
