import sys

n, k = map(int, sys.stdin.readline().split())
robot = list(map(str, sys.stdin.readline().strip("\n")))
answer = 0

for i in range(n):
    if robot[i] == "P":
        for j in range(i - k, i + k + 1):
            if j < 0 or j >= n:
                continue
            if robot[j] == "H":
                robot[j] = "X"
                answer += 1
                break

print(answer)
