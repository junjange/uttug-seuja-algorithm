import math

def solution(w,h):
    result = w * h
    
    num = math.gcd(w, h)
    w //= num
    h //= num
    cnt = w + h - 1

    return result - num * cnt
