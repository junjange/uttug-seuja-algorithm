import itertools
import math

def solution(numbers):
    result = 0
    numbers = list(map(int, numbers))
    number_list = set()
    
    for i in range(1, len(numbers) + 1):
        number = itertools.permutations(numbers, i)
        for j in number:
            number_list.add(int(''.join(map(str, j))))
        
    for i in number_list:
        if primenumber(i) == True and i > 1:
            result += 1
            
    return result


def primenumber(x):
    for i in range (2, int(math.sqrt(x) + 1)):
    	if x % i == 0:
        	return False
    return True	
