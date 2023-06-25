import sys


n = int(sys.stdin.readline())
l = len(str(n))
answer = 0

for i in range(l-1):
    answer += 9 * 10 ** i * (i+1)

print(answer + (n - 10 ** (l-1) + 1) * l)

 
