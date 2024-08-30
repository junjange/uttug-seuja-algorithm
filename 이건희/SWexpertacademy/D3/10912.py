T = int(input())
for test_case in range(1, T + 1):
    S = input()
    cnt = {}
    result = ''
     
    for i in S:
        if i in cnt:
            cnt[i] += 1
        else:
            cnt[i] = 1
             
    for k, v in cnt.items():
        if v % 2 != 0:
            result += k
    result = ''.join(sorted(result))
     
    if result == '':
        print(f'#{test_case} Good')
    else:
        print(f'#{test_case} {result}')
