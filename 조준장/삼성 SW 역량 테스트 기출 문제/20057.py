import sys


def move(cnt, dx, dy, direction):
    global x, y, answer

    for _ in range(cnt+1):
        x += dx
        y += dy
        if x < 0 or y < 0:
            break

        spreads = 0
        for dx, dy, r in rate[direction]:
            nx = x + dx
            ny = y + dy

            if r == 0:
                sand = graph[x][y] - spreads
            else:
                sand = int(graph[x][y] * r)

            if 0 <= nx < n and 0 <= ny < n:
                graph[nx][ny] += sand
            else:
                answer += sand

            spreads += sand


n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = 0
left = [[-2, 0, 0.02], [2, 0, 0.02], [-1, -1, 0.1], [-1, 0, 0.07], [-1, 1, 0.01],
        [1, -1, 0.1], [1, 0, 0.07], [1, 1, 0.01], [0, -2, 0.05], [0, -1, 0]]
right = [[dx, -dy, dz] for dx, dy, dz in left]
up = [[dy, dx, dz] for dx, dy, dz in left]
down = [[-dy, dx, dz] for dx, dy, dz in left]
rate = {"left": left, "right": right, "up": up, "down": down}
x = y = n//2

for i in range(n):
    if i % 2 == 0:
        move(i, 0, -1, "left")
        move(i, 1, 0, "down")
    else:
        move(i, 0, 1, "right")
        move(i, -1, 0, "up")

print(answer)
