import sys


def row_check(r, num):
    for i in range(9):
        if graph[r][i] == num:
            return False
    return True


def column_check(c, num):
    for i in range(9):
        if graph[i][c] == num:
            return False
    return True


def three_check(r, c, num):
    nr = (r // 3) * 3
    nc = (c // 3) * 3

    for i in range(3):
        for j in range(3):
            if graph[nr + i][nc + j] == num:
                return False
    return True


def backtracking(depth):
    if depth >= len(zero):
        for i in range(9):
            print("".join(map(str, graph[i])))
        exit()

    x, y = zero[depth]
    for k in range(1, 9 + 1):
        if row_check(x, k) and column_check(y, k) and three_check(x, y, k):
            graph[x][y] = k
            backtracking(depth + 1)
            graph[x][y] = 0


graph = [list(map(int, sys.stdin.readline().strip())) for _ in range(9)]

zero = []
for i in range(9):
    for j in range(9):
        if graph[i][j] == 0:
            zero.append([i, j])

backtracking(0)
