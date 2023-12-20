T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    S = list(map(str, input().split( )))
    num = N // 2 if N // 2 == N / 2 else N // 2 + 1
     
    f = S[ : num]
    s = S[num : ]
     
    for i in range(len(s)):
        f.insert(1 + i * 2, s[i])
 
    print(f'#{test_case} {" ".join(f)}')
