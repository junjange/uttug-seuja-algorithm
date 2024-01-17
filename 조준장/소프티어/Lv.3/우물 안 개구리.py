import sys

n, m = map(int, sys.stdin.readline().split())
w = list(map(int, sys.stdin.readline().split()))
graph = [[] for _ in range(n + 1)]
answer = 0

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    if graph[i] == []:
        answer += 1
        continue
        
    
    for j in graph[i]:
        if w[i-1] <= w[j-1]:
            break
    else:
        answer += 1
    

print(answer)
