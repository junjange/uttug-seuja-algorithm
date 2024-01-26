import sys
from collections import deque
import copy

def bfs(graph):
    queue = deque([[0, 0]])
    new_graph = copy.deepcopy(graph)
    dx = [1, -1 , 0, 0]
    dy = [0, 0, 1, -1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if new_graph[nx][ny] > 0:
                    new_graph[nx][ny] += 1
                elif new_graph[nx][ny] == 0:
                    new_graph[nx][ny] = -1
                    queue.appendleft([nx, ny])
                    
                    
    for i in range(n):
        for j in range(m):
            if new_graph[i][j] >= 3:
                graph[i][j] = 0
    return graph
                    
                

n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = 0

while graph.count([0] * m) < n:
    graph = bfs(graph)
    answer += 1

print(answer)

    

