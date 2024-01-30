import sys

graph = [list(map(int, sys.stdin.readline().split())) for _ in range(3)]
answer = 1e9

for k in range(1, 4):
    for i in range(3):
        column = 0
        row = 0
        
        for j in range(3):
            if k != graph[i][j]:
                column += abs(graph[i][j] - k)
                
            if k != graph[j][i]:
                row += abs(graph[j][i] - k)

        answer = min(answer, column)
        answer = min(answer, row)

print(answer)
