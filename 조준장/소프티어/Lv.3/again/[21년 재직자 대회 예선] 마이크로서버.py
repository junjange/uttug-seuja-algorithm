import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    m = sorted(list(map(int, sys.stdin.readline().split())))
    answer = 0

    min_service = 0
    for i in m:
        if i > 300:
            break
        min_service += 1

    start = min_service
    end = n - 1

    while start <= end:
        answer += 1
        
        if m[end] > 600:
            pass
            
        elif start != end and m[start] + m[end] <= 900:
            start += 1
        elif min_service > 0:
            min_service -= 1

        end -= 1

    answer += (2 + min_service) // 3
    print(answer)
        
        
