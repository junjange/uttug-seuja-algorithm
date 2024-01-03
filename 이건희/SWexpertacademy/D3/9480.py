from itertools import combinations
alphabet_lowercase = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
 
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    words = [input() for _ in range(N)]
    result = 0
     
    for i in range(1, N + 1):
        box = list(combinations(words, i))
        for j in box:
            word = ''.join(j)
            for k in alphabet_lowercase:
                if k not in word:
                    break
            else:
                result += 1
                 
    print(f'#{test_case} {result}')
