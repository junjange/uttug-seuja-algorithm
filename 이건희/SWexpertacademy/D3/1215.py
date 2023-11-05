for test_case in range(1, 11):
    N = int(input())
    words = []
    result = 0
    for i in range(8):
        word =input()
        words.append(word)
 
    for i in range(8):
        for j in range(8 - N + 1):
            now = words[i][j : j + N]
            if now == now[::-1]:
                result += 1
                 
    for i in range(8):
        for j in range(8 - N + 1):
            now = ''
            for k in range(N):
                now += words[j + k][i]
            if now == now[::-1]:
                result += 1
 
    print(f'#{test_case} {result}')
