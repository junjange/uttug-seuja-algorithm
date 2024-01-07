import sys


def solution(x, y, n):
    color = graph[x][y]

    for i in range(x, x + n):
        for j in range(y, y + n):
            if graph[i][j] != color:
                solution(x, y, n // 2)
                solution(x, y + n // 2, n // 2)
                solution(x + n // 2, y, n // 2)
                solution(x + n // 2, y + n // 2, n // 2)
                return

    if color == 0:
        answer.append(0)
    else:
        answer.append(1)


n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
answer = []

solution(0, 0, n)

print(answer.count(0))
print(answer.count(1))
