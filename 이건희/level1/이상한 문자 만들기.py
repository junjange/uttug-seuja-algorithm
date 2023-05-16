def solution(s):
    s = s.split(' ')
    result = []
    for i in s:
        word = []
        for j in range(len(i)):
            if j % 2 == 0:
                word.append(i[j].upper())
            else:
                word.append(i[j].lower())
        word = ''.join(word)
        result.append(word)
    return ' '.join(result)
