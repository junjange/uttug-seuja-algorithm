T = int(input())
for test_case in range(1, T + 1):
    S = input()
    result = 0
     
    for i in range(len(S)):
        if i != ord(S[i]) - 97:
            break
        result += 1
             
    print(f'#{test_case} {result}')
