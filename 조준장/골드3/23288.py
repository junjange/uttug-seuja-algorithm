import sys
from collections import deque

"""

  2
4 1 3
  5
  6

# 동쪽으로 이동
  2
6 4 1
  5
  3

"""

def solution(v):
    if v == 0:  # 동
        dice[1], dice[3], dice[4], dice[6] = dice[4], dice[1], dice[6], dice[3]

    elif v == 1:  # 남
        dice[1], dice[2], dice[5], dice[6] = dice[2], dice[6], dice[1], dice[5]

    elif v == 2:  # 서
        dice[1], dice[3], dice[4], dice[6] = dice[3], dice[6], dice[1], dice[4]

    else:  # 북
        dice[1], dice[2], dice[5], dice[6] = dice[5], dice[1], dice[6], dice[2]


def bfs(x, y):
    answer = 0
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    d = 0

    for _ in range(k):
        if not 0 <= x + dx[d] < n or not 0 <= y + dy[d] < m:
            d = (d + 2) % 4

        x = x + dx[d]
        y = y + dy[d]
        answer += graph[x][y] * find_c(x, y, graph[x][y])
        solution(d)
        if dice[6] > graph[x][y]:
            d = (d + 1) % 4
        elif dice[6] < graph[x][y]:
            d = (d + 3) % 4
    return answer


def find_c(x, y, target):
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    queue = deque([[x, y]])
    visited = [[False for _ in range(m)] for _ in range(n)]
    visited[x][y] = True
    cnt = 1
    while queue:
        tx, ty = queue.popleft()
        for i in range(4):
            nx = tx + dx[i]
            ny = ty + dy[i]
            if 0 <= nx < n and 0 <= ny < m:

                if graph[nx][ny] == target and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append([nx, ny])
                    cnt += 1

    return cnt


n, m, k = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dice = [0, 1, 2, 3, 4, 5, 6]
print(bfs(0, 0))
