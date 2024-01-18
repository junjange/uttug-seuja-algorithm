import sys
from collections import deque
import copy


def backtracking(depth, point, graph):
    global answer

    if depth >= 3:
        answer = max(answer, point)
        return

    visited = [[False for _ in range(n)] for _ in range(n * 3)]

    for i in range(n * 2, n * 3):
        for j in range(n):
            if not visited[i][j] and graph[i][j] != 0:
                visited[i][j] = True
                new_graph = [row[:] for row in graph]
                new_point = bfs(new_graph, i, j, visited)
                backtracking(depth + 1, point + new_point, new_graph)


def bfs(graph, x, y, visited):
    
    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    queue = deque([[x, y]])
    number = graph[x][y]
    graph[x][y] = 0
    cnt = 1
    
    max_X = x
    min_Y = y
    max_Y = y
    
    while queue:
        sx, sy = queue.popleft()
 
        for i in range(len(dx)):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if n * 2 <= nx < n * 3 and 0 <= ny < n:
                if number == graph[nx][ny]:
                    visited[nx][ny] = True
                    graph[nx][ny] = 0
                    queue.append([nx, ny])
                    cnt += 1
                    min_Y = min(min_Y, ny)
                    max_X = max(max_X, nx)
                    max_Y = max(max_Y, ny)

    gravity(graph)
 
    return cnt + (max_X - x + 1) * (max_Y - min_Y + 1)
    
                
def gravity(graph):
    for j in range(n):
        zero_count = sum(1 for i in range(n * 3) if graph[i][j] == 0)
        zeros = [0] * zero_count + [graph[i][j] for i in range(n * 3) if graph[i][j] != 0]
        for i in range(n * 3):
            graph[i][j] = zeros[i]
    return graph



n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n * 3)]
answer = 0

backtracking(0, 0, graph)
print(answer)
