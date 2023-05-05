def solution(a, b, n):
    result = 0
    while n >= a:
        num = n // a
        result += num * b
        n = n % a + num * b
    return result
