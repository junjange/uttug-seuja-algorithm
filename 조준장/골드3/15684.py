import sys


def visit():
    for i in range(n):
        start = i
        for j in range(h):
            if graph[j][start]:
                start += 1

            elif start > 0 and graph[j][start - 1]:
                start -= 1
        if start != i:
            return False
    return True


def backtracking(x, y, cnt):
    global answer
    if visit():
        answer = min(answer, cnt)
        return

    if cnt == 3 or cnt >= answer:
        return

    for i in range(x, h):
        if i == x:
            start = y
        else:
            start = 0
        for j in range(start, n - 1):
            if not graph[i][j] and not graph[i][j + 1]:
                if j > 0 and graph[i][j - 1]:
                    continue
                graph[i][j] = True
                backtracking(i, j, cnt + 1)
                graph[i][j] = False


n, m, h = map(int, sys.stdin.readline().split())
if m == 0:
    print(0)
    exit(0)

graph = [[False for _ in range(n)] for _ in range(h)]
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a - 1][b - 1] = True
answer = 4
backtracking(0, 0, 0)
print(answer if answer < 4 else -1)
