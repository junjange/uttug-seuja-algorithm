T = int(input())
for test_case in range(1, T + 1):
    N, A, B = map(int, input().split())
    maxNum = min(A, B)
    minNum = A + B - N if A + B - N > 0 else 0
    print(f'#{test_case} {maxNum} {minNum}')
