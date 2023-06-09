def solution(elements):
    element = 2 * elements
    result = set()
    num = 0
    
    for i in range(1, len(elements) + 1):
        for j in range(len(element) - i + 1):
            num = sum(element[j:j + i])
            result.add(num)
            
    return len(list(result))
