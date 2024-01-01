"""
- 완탐
"""
import sys

n, m = map(int, sys.stdin.readline().split())
graph = [list(map(str, sys.stdin.readline().strip())) for _ in range(n)]
answer = []

for i in range(n - 7):
    for j in range(m - 7):

        wb = 0
        bw = 0

        for k in range(i, i + 8):
            for l in range(j, j + 8):

                if (k + l) % 2 == 0:
                    if graph[k][l] == "W":
                        bw += 1
                    else:
                        wb += 1

                else:
                    if graph[k][l] == "B":
                        bw += 1
                    else:
                        wb += 1

        answer.append(wb)
        answer.append(bw)

print(min(answer))
