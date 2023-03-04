import sys


def dfs(x, y, count):
    global answer
    if x < 0 or x >= r or y < 0 or y >= c:
        return False

    if x == 0 and y == c-1:
        if count == k:
            answer += 1
        return

    if graph[x][y] == ".":

        graph[x][y] = "T"
        dfs(x-1, y, count+1)
        graph[x][y] = "."

        graph[x][y] = "T"
        dfs(x+1, y, count+1)
        graph[x][y] = "."

        graph[x][y] = "T"
        dfs(x, y-1, count+1)
        graph[x][y] = "."

        graph[x][y] = "T"
        dfs(x, y+1, count+1)
        graph[x][y] = "."

        return True
    return True


r, c, k = map(int, sys.stdin.readline().split())
graph = [list(map(str, sys.stdin.readline().strip())) for _ in range(r)]
answer = 0
dfs(r-1, 0, 1)
print(answer)
