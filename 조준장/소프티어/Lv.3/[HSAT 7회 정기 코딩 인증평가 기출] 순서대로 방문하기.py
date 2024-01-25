import sys
from collections import deque
import copy

def bfs(start_loc, ex, ey):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    queue = deque(start_loc)
    end_loc = []
    while queue:
        x, y, new_visited = queue.popleft()

        if x == ex and y == ey:
            end_loc.append([x, y, new_visited])
            continue
            
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 0 and not new_visited[nx][ny]:
                queue_visited = copy.deepcopy(new_visited)
                queue_visited[nx][ny] = True
                queue.append([nx, ny, queue_visited])
    return end_loc
    

n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
loc = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
visited = [[False for _ in range(n)] for _ in range(n)]
visited[loc[0][0]-1][loc[0][1]-1] = True
start_loc = [[loc[0][0]-1, loc[0][1]-1, visited]]
for i in range(1, m):
    start_loc = bfs(start_loc, loc[i][0]-1, loc[i][1]-1)

print(len(start_loc))
