import sys

n = int(sys.stdin.readline())
bus = list(map(int, sys.stdin.readline().split()))
answer = 0
for i in range(n):
    cnt = 0
    for j in range(i + 1, n):
        if bus[i] < bus[j]:
           cnt += 1
        elif bus[i] > bus[j]:
            answer += cnt
print(answer)
