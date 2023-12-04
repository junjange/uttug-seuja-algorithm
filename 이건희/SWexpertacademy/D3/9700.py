T = int(input())
for test_case in range(1, T + 1):
    p, q = map(float, input().split())
    result = 'YES' if (1 - p) * q < p * (1 - q) * q else 'NO'
    print(f'#{test_case} {result}')
