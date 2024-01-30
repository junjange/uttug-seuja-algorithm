import sys
from collections import deque, defaultdict
import copy


def graph_gravite(graph):
    while True:
        moved = 0
        for i in range(3 * n - 1):
            for j in range(n):
                if graph[i][j] != 0 and graph[i + 1][j] == 0:
                    graph[i + 1][j] = graph[i][j]
                    graph[i][j] = 0
                    moved += 1
        if moved == 0:
            break
    return graph

    
def bfs(graph, x, y, color):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    queue = deque([[x, y]])
    cnt = 1
    graph[x][y] = 0

    max_x = x
    max_y = y
    min_y = y
    while queue:
        sx, sy = queue.popleft()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]
            
            if 2 * n <= nx < 3 * n and 0 <= ny < n:
                if graph[nx][ny] == color:
                    max_x = max(max_x, nx)
                    max_y = max(max_y, ny)
                    min_y = min(min_y, ny)
                    
                    graph[nx][ny] = 0
                    cnt += 1
                    queue.append([nx, ny])
    graph = graph_gravite(graph)
    
    return graph, cnt + (max_x - x + 1) * (max_y - min_y + 1)
        

def backtracking(depth, graph, point):
    global colors, answer
    
    new_colors = copy.deepcopy(colors)
    if depth > 3:
        answer = max(answer, point)
        return

    for i in range(2 * n, 3 * n):
        for j in range(n):
            if graph[i][j] != 0 and new_colors[graph[i][j]]:
                new_colors[graph[i][j]] = 0
                new_graph = copy.deepcopy(graph)
                new_graph, new_point = bfs(new_graph, i, j, graph[i][j])
                backtracking(depth + 1, new_graph, point + new_point)
                new_colors[graph[i][j]] = 1
                


n = int(sys.stdin.readline())
graph = []
answer = 0
colors = defaultdict(int)

for i in range(3 * n):
    temp_graph = list(map(int, sys.stdin.readline().split()))
    for j in range(n):
        colors[temp_graph[j]] = 1
    graph.append(temp_graph)

backtracking(1, graph, 0)
print(answer)
