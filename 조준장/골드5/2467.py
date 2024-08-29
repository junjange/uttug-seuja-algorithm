import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split(" ")))

start = 0
end = n - 1
temp = 2000000000
answer = [arr[start], arr[end]]
while start < end:
    mid = arr[start] + arr[end]
    if abs(mid) < temp:
        temp = abs(mid)
        answer = [arr[start], arr[end]]
    if mid == 0:
        break
    if mid < 0:
        start += 1
    else:
        end -= 1

print(answer[0], answer[1])
