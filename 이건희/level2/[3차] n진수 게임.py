def solution(n, t, m, p):    
    result = ''
    num = '0'
    
    for i in range(1, t *m):
        num += str(convert(i, n))
        
    for i in range(len(num)):
        if i % m == p - 1:
            result += num[i]
            
        if len(result) == t:
            return result
    
    
def convert(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)
    if q == 0:
        return T[r]
    else:
        return convert(q, base) + T[r]
