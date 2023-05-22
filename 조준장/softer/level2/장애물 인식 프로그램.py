import sys

def dfs(x, y):
    global cnt
    if x >= n or x < 0 or y >= n or y < 0:
        return False
    
    if graph[x][y] == "1":
        graph[x][y] = "0"
        cnt += 1

        dfs(x+1, y)
        dfs(x-1, y)
        dfs(x, y+1)
        dfs(x, y-1)
        return True
    
    return False

answer = []
n = int(sys.stdin.readline())
graph = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(n)]
for i in range(n):
    for j in range(n):
        if graph[i][j] == "1":
            cnt = 0
            dfs(i, j)
            answer.append(cnt)

answer.sort()
print(len(answer))
[print(a) for a in answer]
