from itertools import permutations

def solution(expression):
    result = []
    operator = permutations(['+', '-', '*'])
    
    for i in operator:
        f, s = i[0], i[1]
        nums = []
        for j in expression.split(f):
            temp = [f"({i})" for i in j.split(s)]
            nums.append(f'({s.join(temp)})')
        result.append(abs(eval(f.join(nums))))
        
    return max(result)
