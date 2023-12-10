import math
 
T = int(input())
for test_case in range(1, T + 1):
    N, D = map(int, input().split())
    N /= 2 * D + 1
    print(f'#{test_case} {math.ceil(N)}')
