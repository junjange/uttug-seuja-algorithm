def solution(brown, yellow):
    result = []
    a, b = 0, 0
    
    for i in range(1, yellow + 1):
        if yellow % i == 0:
            a = i
            b = yellow / i
            if 2 * (a + b) + 4 == brown:
                result.append(a + 2)
                result.append(b + 2)
                break
                
    result.sort(reverse = True)
    return result
