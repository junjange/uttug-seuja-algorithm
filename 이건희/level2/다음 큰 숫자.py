def solution(n):
    result = 0
    num = bin(n)[2:].count('1')

    for i in range(n + 1, 1000001):
        if num == bin(i)[2:].count('1'):
            return i
