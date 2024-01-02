T = int(input())
for test_case in range(1, T + 1):
    D, H, M = map(int, input().split())
    time = (11 * 24 + 11)  * 60 + 11
    result = (D * 24 + H)  * 60 + M
     
    if result - time < 0:
        print(f'#{test_case} -1')
    else:
        print(f'#{test_case} {result - time}')
