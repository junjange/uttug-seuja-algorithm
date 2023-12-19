T = int(input())
for test_case in range(1, T + 1):
    m, d = map(int, input().split())
    days = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day = 3 + d
     
    for i in range(m - 1):
        day += days[i]
         
    print(f'#{test_case} {day % 7}')
