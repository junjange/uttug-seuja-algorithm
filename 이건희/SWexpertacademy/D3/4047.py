T = int(input())
for test_case in range(1, T + 1):
    T = input()
    S = {}
    H = {}
    D = {}
    C = {}
    result = 0
    for i in range(0, len(T), 3):
        pattern = T[i]
        num = T[i + 1 : i + 3]
 
        if pattern == 'S':
            if num in S:
                result = 1
                break
            S[num] = 1
 
        elif pattern == 'H':
            if num in H:
                result = 1
                break
            H[num] = 1
 
        elif pattern == 'D':
            if num in D:
                result = 1
                break
            D[num] = 1
 
        elif pattern == 'C':
            if num in C:
                result = 1
                break
            C[num] = 1
         
    print(f'#{test_case} {13 - len(S)} {13 - len(D)} {13 - len(H)} {13 - len(C)}') if result == 0 else print(f'#{test_case} ERROR')
