import sys
sys.setrecursionlimit(10**8)

def dfs1(current, parent): #top down
    subtreeSize[current] = 1
    for child, weight in graph[current]:
        if child != parent:
            dfs1(child, current)
            distSum[current] += distSum[child] + subtreeSize[child] * weight
            subtreeSize[current] += subtreeSize[child]
    return
    

def dfs2(current, parent): #bottom up
    for child, weight in graph[current]:
        if child != parent:
            distSum[child] = distSum[current] + weight * (n - 2 * subtreeSize[child])
            dfs2(child, current)
    return
    
n = int(sys.stdin.readline())
graph = [[] for _ in range(n + 1)]
subtreeSize = [0 for i in range(n + 1)]
distSum = [0 for i in range(n + 1)]
for i in range(n - 1):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

dfs1(1, 1) #calculate sub tree size(갯수)
dfs2(1, 1)
for i in range(1, n + 1):
    print(distSum[i])
