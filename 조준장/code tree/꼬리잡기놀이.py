"""
10:30 시작
12:10 예제 통과
기능 목록
- 각 팀은 머리사람을 따라서 한 칸 이동
- 각 라운드마다 공이 정해진 선을 따라 던져진다.(4방향 우/위/왼/아래)
- 공이 던져지는 경우에 해당 선에 사람이 있으면 최초에 만나게 되는 사람만이 공을 얻게 되어 점수를 얻게된다.
    -  점수는 해당 사람이 머리사람을 시작으로 팀 내에서 k번째 사람이라면 k의 제곱만큼 점수를 얻게 됩니다.
    - 공을 획득한 팀의 경우에는 머리사람과 꼬리사람이 바뀝니다. 즉 방향을 바꾸게 됩니다.
- 각 팀이 획득한 점수의 총합을 구해주세요.

미해결..
"""
import sys

def move(x, y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    new_graph = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    visited[x][y] = True
    queue = [[x, y]]
    # new_graph[x][y] = 4

    while queue:
        sx, sy = queue.pop()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] != 0:

                if graph[sx][sy] == 3 and graph[nx][ny] == 1:
                    new_graph[sx][sy] = 1
                    # visited[nx][ny] = True

                elif graph[sx][sy] == 3 and graph[nx][ny] == 4:
                    new_graph[sx][sy] = 4
                    # visited[sx][sy] = True
                    
                elif graph[sx][sy] == 1 and graph[nx][ny] == 4:
                    new_graph[nx][ny] = graph[sx][sy]
                    visited[nx][ny] = True
                    queue.append([nx, ny])
                elif graph[nx][ny] != 4:
                    new_graph[nx][ny] = graph[sx][sy]
                    visited[nx][ny] = True
                    queue.append([nx, ny])
    

    for i in range(n):
        for j in range(n):
            if new_graph[i][j] != 0:
                graph[i][j] = new_graph[i][j]
    

def graph_change(graph):
    new_graph = []

    for i in range(n):
        temp_graph = []
        for j in range(-1, -n-1, -1):
            temp_graph.append(graph[j][i])
        new_graph.append(temp_graph)

    return new_graph  

def ball_run(start):
    for i in range(start, n):
        for j in range(n):
            if graph[i][j] != 4 and graph[i][j] != 0:
                point = direction_change(i, j)
                # print(point)
                return point ** 2
    return 0

def direction_change(x, y):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    visited = [[False] * n for _ in range(n)]
    queue = [[x, y, 1]]
    currnet_position = 1
    visited[x][y] = True
    while queue:
        sx, sy, cnt = queue.pop()

        for i in range(4):
            nx = sx + dx[i]
            ny = sy + dy[i]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] != 0 and graph[nx][ny] != 4:
                if graph[nx][ny] == 1:
                    graph[nx][ny] = 3
                    currnet_position = cnt+1
                
                elif graph[nx][ny] == 3:
                    graph[nx][ny] = 1

                visited[nx][ny] = True
                queue.append([nx, ny, cnt+1])
    return currnet_position




def graph_print(graph):
    for g in graph:
        print(g)
    print()

n, m, k = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
target = []
answer = 0
n_round = 0

for count in range(k):
    target = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 3:
                target.append([i, j])


    for t in target:
        move(t[0], t[1])

    side, p = divmod(count, n)
    # print(side, p)
   
    graph_print(graph)
    answer += ball_run(p)
    # print(answer)
    # print(side % 4, n_round)
    if side % 4 != n_round:
        n_round += 1
        graph = graph_change(graph)

print(answer)
