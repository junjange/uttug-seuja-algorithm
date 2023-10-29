import sys

n, x = map(int, sys.stdin.readline().split())
m = list(map(int, sys.stdin.readline().split()))
if max(m) == 0:
    print("SAD")

else:
    window = sum(m[:x])
    answer = window
    cnt = 1
    for i in range(x, n):
        window += m[i] - m[i - x]

        if answer < window:
            answer = window
            cnt = 1
        elif answer == window:
            cnt += 1

    print(answer)
    print(cnt)
