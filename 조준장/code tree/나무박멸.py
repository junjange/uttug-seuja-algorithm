"""
- 제초제의 경우 k의 범위만큼 대각선으로 퍼지며, 벽이 있는 경우 가로막혀서 전파되지 않습니다.
- 인접한 네 개의 칸 중 나무가 있는 칸의 수만큼 나무가 성장합니다. 성장은 모든 나무에게 동시에 일어납니다.
- 기존에 있었던 나무들은 인접한 4개의 칸 중 벽, 다른 나무, 제초제 모두 없는 칸에 번식을 진행합니다.
    - 이때 각 칸의 나무 그루 수에서 총 번식이 가능한 칸의 개수만큼 나누어진 그루 수만큼 번식이 되며, 나눌 때 생기는 나머지는 버립니다.
    - 번식의 과정은 모든 나무에서 동시에 일어나게 됩니다.
- 각 칸 중 제초제를 뿌렸을 때 나무가 가장 많이 박멸되는 칸에 제초제를 뿌립니다.
- 나무가 있는 칸에 제초제를 뿌리게 되면 4개의 대각선 방향으로 k칸만큼 전파되게 됩니다. 
    - 단 전파되는 도중 벽이 있거나 나무가 아얘 없는 칸이 있는 경우, 그 칸 까지는 제초제가 뿌려지며 그 이후의 칸으로는 제초제가 전파되지 않습니다.
    - 제초제가 뿌려진 칸에는 c년만큼 제초제가 남아있다가 c+1년째가 될 때 사라지게 됩니다.
    - 제초제가 뿌려진 곳에 다시 제초제가 뿌려지는 경우에는 새로 뿌려진 해로부터 다시 c년동안 제초제가 유지됩니다.
"""
import sys
import copy


# 성장
def grow_tree():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    new_graph = copy.deepcopy(graph)
    for x in range(n):
        for y in range(n):
            if graph[x][y] > 0:
                new_tree = []
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]

                    if 0 <= nx < n and 0 <= ny < n:
                        if graph[nx][ny] > 0: 
                            new_graph[x][y] += 1
                        
    return new_graph


# 번식
def spread_tree():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    new_graph = copy.deepcopy(graph)
    for x in range(n):
        for y in range(n):
            if graph[x][y] > 0:
                new_tree = []
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]

                    if 0 <= nx < n and 0 <= ny < n:
                        if graph[nx][ny] == 0 and years[nx][ny] == 0:
                            new_tree.append([nx, ny])
                        

                if len(new_tree) > 0:
                    breeding_tree = int(graph[x][y] // len(new_tree))

                    for nt in new_tree:
                        ntx, nty = nt
                        new_graph[ntx][nty] += breeding_tree
                
    return new_graph

 # 제초제를 뿌릴 위치 선정
def herbicide_location_select():
    global answer
    dx = [1, -1, 1, -1]
    dy = [1, 1, -1, -1]
    location = [0, 0]
    max_tree_cnt = 0
    for x in range(n):
        for y in range(n):
            if graph[x][y] > 0:
                tree_cnt = graph[x][y]
                for i in range(4):
                    for j in range(1, k+1):
                        nx = x + dx[i] * j
                        ny = y + dy[i] * j
                        
                        if not (0 <= nx < n and 0 <= ny < n):
                            break

                        if graph[nx][ny] <= 0:
                            break
                        if graph[nx][ny] > 0:
                            tree_cnt += graph[nx][ny]

                if max_tree_cnt < tree_cnt:
                    max_tree_cnt = tree_cnt
                    location = [x, y]
    answer += max_tree_cnt
    return location

                
# 제초제를 뿌리는 작업
def herbicide_run(x, y):
    dx = [1, -1, 1, -1]
    dy = [1, 1, -1, -1]
    
    years[x][y] = c
    graph[x][y] = 0
    for i in range(4):
        for j in range(1, k+1):
            nx = x + dx[i] * j
            ny = y + dy[i] * j

            if not (0 <= nx < n and 0 <= ny < n):
                 break

            if graph[nx][ny] == -1:
                break

            if graph[nx][ny] == 0:
                years[nx][ny] = c
                break

            if graph[nx][ny] > 0:
                years[nx][ny] = c
                graph[nx][ny] = 0


# 제초제 년도 갱신
def init_year():
    for i in range(n):
        for j in range(n):
            if years[i][j] > 0:
                years[i][j] -= 1
            

n, m, k, c = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
years = [[0]*n for _ in range(n)]
answer = 0

for _ in range(m):
    graph = grow_tree()
    graph = spread_tree()
    location = herbicide_location_select()
    init_year()
    herbicide_run(location[0], location[1])
            
print(answer)
