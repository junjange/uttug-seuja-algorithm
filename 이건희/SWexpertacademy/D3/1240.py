T = int(input())
change = {'1011000': 0, '1001100': 1, '1100100': 2, '1011110': 3, '1100010': 4, '1000110': 5, '1111010': 6, '1101110': 7, '1110110': 8, '1101000': 9}
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    result = 0
    password = 0
    cryptogram = ''
     
    for _ in range(N):
        n = input()
        if '1' in n:
            cryptogram = n
 
    l = cryptogram[::-1].find('1')
    words = cryptogram[::-1][l : l + 56]
    words = [words[i:i+7] for i in range(0, len(words), 7)]
     
    for i, word in enumerate(words):
        now = change[word]
        password += now
        if i % 2 == 0:
            result += now
        else:
            result += now * 3
 
    if result % 10 == 0:
        print(f'#{test_case} {password}')
    else:
        print(f'#{test_case} 0')
