T = int(input())
Day = {1 : 31, 2 : 28, 3 : 31, 4 : 30, 5 : 31, 6 : 30, 7 : 31, 8 : 31, 9 : 30, 10 : 31, 11 : 30, 12 : 31}
for test_case in range(1, T + 1):
    firstMonth, firstDay, secondMonth, secondDay = map(int, input().split())
     
    if secondMonth > firstMonth:
        result = (Day[firstMonth] - firstDay) + secondDay
        for i in range(firstMonth + 1, secondMonth):
            result += Day[i]
    else:
        result = secondDay - firstDay
         
    print(f"#{test_case} {result + 1}")
