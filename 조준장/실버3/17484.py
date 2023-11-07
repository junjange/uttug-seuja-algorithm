import sys


def dfs(col, row, d, low, answer):
    if col == n - 1:
        return min(low, answer)
    for i in dy:
        if i != d:
            if 0 <= col < n and 0 <= row + i < m:
                low = dfs(col + 1, row + i, i, low, answer + graph[col + 1][row + i])
    return low


n, m = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dy = [-1, 0, 1]
answer = 1e9

for i in range(m):
    answer = min(dfs(0, i, 2, answer, graph[0][i]), answer)

print(answer)
