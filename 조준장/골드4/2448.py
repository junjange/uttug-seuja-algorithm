"""
- 재귀
"""
import sys


def recursion(i, j, size):
    if size == 3:
        graph[i][j] = "*"
        graph[i + 1][j - 1] = graph[i + 1][j + 1] = "*"
        for k in range(-2, 3):
            graph[i + 2][j - k] = "*"

    else:
        new_size = size // 2
        recursion(i, j, new_size)
        recursion(i + new_size, j - new_size, new_size)
        recursion(i + new_size, j + new_size, new_size)


n = int(sys.stdin.readline())
graph = [[" "] * 2 * n for _ in range(n)]

recursion(0, n - 1, n)

for g in graph:
    print("".join(g))
