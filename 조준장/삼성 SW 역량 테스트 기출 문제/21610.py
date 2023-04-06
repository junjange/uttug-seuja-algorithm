import sys


def move_cloud(clouds, d, s):
    dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
    dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]

    new_clouds = []
    for cloud in clouds:
        x, y = cloud

        nx = (x + dx[d] * s) % n
        ny = (y + dy[d] * s) % n
        new_clouds.append([nx, ny])

    return new_clouds


def rain_cloud(clouds):
    for cloud in clouds:
        x, y = cloud
        graph[x][y] += 1
        visited[x][y] = True


def magic_cloud(clouds):
    dx = [1, -1, 1, -1]
    dy = [1, -1, -1, 1]

    for cloud in clouds:
        x, y = cloud
        cnt = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] > 0:
                cnt += 1

        graph[x][y] += cnt


def create_cloud():
    new_clouds = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] >= 2 and not visited[i][j]:
                graph[i][j] -= 2
                new_clouds.append([i, j])

    return new_clouds


def sum_water(graph):
    return sum([sum(g) for g in graph])


n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
order = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
clouds = [[n-2, 0], [n-2, 1], [n-1, 0], [n-1, 1]]

for i in range(m):
    visited = [[False] * n for _ in range(n)]
    clouds = move_cloud(clouds, order[i][0], order[i][1])
    rain_cloud(clouds)
    magic_cloud(clouds)
    clouds = create_cloud()

print(sum_water(graph))
