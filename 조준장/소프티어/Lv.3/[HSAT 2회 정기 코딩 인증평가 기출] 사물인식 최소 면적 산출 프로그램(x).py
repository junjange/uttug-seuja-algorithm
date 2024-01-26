import sys


def dfs(depth, minX, minY, maxX, maxY):
    global answer

    if depth > K:
        nx = abs(maxX - minX)
        ny = abs(maxY - minY)
        answer = min(answer, nx * ny)
        return
    
    for x, y in color[depth]:
        nMinX = min(minX, x)
        nMinY = min(minY, y)
        nMaxX = max(maxX, x)
        nMaxY = max(maxY, y)
        
        nx = nMaxX - nMinX
        ny = nMaxY - nMinY
        
        if answer > nx * ny:
            dfs(depth + 1, nMinX, nMinY, nMaxX, nMaxY)


n, K = map(int, sys.stdin.readline().split())
color = [[] for _ in range(K + 1)]
for _ in range(n):
    x, y, k = map(int, sys.stdin.readline().split())
    color[k].append([x, y])
answer = 1e9

for x, y in color[1]:
    dfs(2, x, y, x, y)

print(answer)
