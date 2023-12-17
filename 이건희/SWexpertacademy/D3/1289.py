T = int(input())
for test_case in range(1, T + 1):
    B = str(input())
    result = 0
    now = 0
     
    for i in B:
        if int(i) != now:
            result += 1
            now = int(i)
             
    print(f'#{test_case} {result}')
