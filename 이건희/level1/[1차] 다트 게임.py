def solution(dartResult):
    score = []
    word = ''
    for i in dartResult:
        if i.isnumeric():
            word += i
        elif i == 'S':
            word = int(word)**1
            score.append(word)
            word = ''
        elif i == 'D':
            word = int(word)**2
            score.append(word)
            word = ''
        elif i == 'T':
            word = int(word)**3
            score.append(word)
            word = ''
        elif i == '#':
            score[-1] *= -1
        elif i == '*':
            if len(score) > 1:
                score[-2] *= 2
                score[-1] *= 2
            else:
                score[-1] *= 2
    return sum(score)
