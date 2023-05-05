def solution(food):
    result = ''
    for i in range(1, len(food)):
        result += (food[i] // 2) * str(i)
    return result + '0' + ''.join(reversed(result))
