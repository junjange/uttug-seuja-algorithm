import sys


def bs(x, mid):
    if x[1] - x[0] > mid:
        return False
    if x[-1] - x[-2] > mid:
        return False

    for i in range(1, len(x)-2):
        if (x[i+1]-x[i])/2 > mid:
            return False
    return True


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
x = [0] + list(map(int, sys.stdin.readline().split())) + [n]
answer = []
start = 1
end = n

while start <= end:
    mid = (start + end) // 2
    if bs(x, mid):
        answer.append(mid)
        end = mid-1
    else:
        start = mid+1
print(sorted(answer)[0])


