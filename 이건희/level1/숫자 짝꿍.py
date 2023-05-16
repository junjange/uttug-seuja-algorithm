from collections import Counter

def solution(X, Y):
    result = ''
    x = Counter(X)
    y = Counter(Y)

    for i in x:
        cnt = 0
        if i in y:
            cnt = min(x[i], y[i])
            for j in range(cnt):
                result += i

    if result == '':
        return '-1'
    else:
        result = sorted(result, reverse = True)
        if result[0] == '0':
            return '0'
    return ''.join(result)
