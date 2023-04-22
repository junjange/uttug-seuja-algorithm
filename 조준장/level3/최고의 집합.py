def solution(n, s):
    if n > s:
        return [-1]
    
    x, y = divmod(s, n)
    
    return [x] * (n - y) + [x + 1] * y
