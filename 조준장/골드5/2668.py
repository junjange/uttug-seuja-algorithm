import sys


def dfs(start: int, num: int):
    visited.add(num)

    if arr[num] not in visited:
        dfs(start, arr[num])
    elif arr[num] in visited and start == arr[num]:
        answer.append(start)


n = int(sys.stdin.readline())
arr = [0] + [int(sys.stdin.readline()) for _ in range(n)]
answer = []
for i in range(1, n + 1):
    visited = set()
    dfs(i, i)

print(len(answer))
for a in answer:
    print(a)
