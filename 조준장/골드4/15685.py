import sys

n = int(sys.stdin.readline())
graph = [[0] * 101 for _ in range(101)]
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

for _ in range(n):
    x, y, d, g = map(int, sys.stdin.readline().split())
    graph[x][y] = 1
    moves = [d]

    for _ in range(g):
        new_moves = []
        for i in range(len(moves)):
            new_moves.append((moves[-i-1]+1) % 4)
        moves.extend(new_moves)

    for move in moves:
        nx = x + dx[move]
        ny = y + dy[move]
        graph[nx][ny] = 1
        x, y = nx, ny


answer = 0
for i in range(100):
    for j in range(100):
        if graph[i][j] and graph[i+1][j] and graph[i][j+1] and graph[i+1][j+1]:
            answer += 1

print(answer)



