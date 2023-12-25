T = int(input())
for test_case in range(1, T + 1):
    S = input()
    cnt = 0
     
    for i in S:
        if i == 'x':
            cnt += 1
    result = 'YES' if cnt < 8 else 'NO'
     
    print(f'#{test_case} {result}')
