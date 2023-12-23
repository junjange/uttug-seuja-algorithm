T = int(input())
for test_case in range(1, T + 1):
    words = []
    result = ''
    maxNum = 0
    for i in range(5):
        word = list(input())
        maxNum = max(maxNum, len(word))
        words.append(word)
     
    for i in range(maxNum):
        for j in range(5):
            if len(words[j]) > 0:
                result += words[j].pop(0)
                 
    print(f'#{test_case} {result}')
