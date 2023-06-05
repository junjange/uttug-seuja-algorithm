import math

def solution(arr):
    num = arr[0]
    
    for i in range(1, len(arr)):
        num = lcm(num, arr[i])
        
    return num

def lcm(a, b):
    return int( a * b / math.gcd(a, b))
