T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    u = N - M
    t = M -u
    print(f'#{test_case} {t} {u}')
