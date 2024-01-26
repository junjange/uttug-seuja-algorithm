import sys

n, m, k = map(int, sys.stdin.readline().split())
first_order = list(map(int, sys.stdin.readline().split()))
second_order = list(map(int, sys.stdin.readline().split()))

answer = 0

for i in range(n):
    idx = 0
    for j in range(m):
        if i + idx >= n:
            break

        if first_order[i + idx] == second_order[j]:
            idx += 1
        else:
            answer = max(answer, idx)
            idx = 0
    
    answer = max(answer, idx)


for i in range(m):
    idx = 0
    for j in range(n):
        if i + idx >= m:
            break

        if second_order[i + idx] == first_order[j]:
            idx += 1
        else:
            answer = max(answer, idx)
            idx = 0
    
    answer = max(answer, idx)
    
print(answer)
