for test_case in range(1, 11):
    n = int(input())
    words = [input() for _ in range(100)]
    result = 1
     
    for i in range(100):
        word = words[i]
        for j in range(99):
            for k in range(j + 1, 100):
                if word[j : k +1] == word[j : k + 1][::-1]:
                    result = max(result, len(word[j : k + 1]))
                     
    for i in range(100):
        word =''
        for j in range(100):
            word += words[j][i]
        for j in range(99):
            for k in range(j + 1, 100):
                if word[j : k + 1] == word[j : k + 1][::-1]:
                    result = max(result, len(word[j : k + 1]))
                     
    print(f'#{test_case} {result}')
