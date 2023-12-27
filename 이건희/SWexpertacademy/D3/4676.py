T = int(input())
for test_case in range(1, T + 1):
    S = list(input())
    H = int(input())
    l = list(map(int, input().split()))
    S = [''] + S
    location = {}
     
    for i in l:
        if i in location:
            location[i] += 1
        else:
            location[i] = 1
 
    for k, v in location.items():
        S[k] += v * '-'
         
    result = ''.join(S)
    print(f'#{test_case} {result}')
