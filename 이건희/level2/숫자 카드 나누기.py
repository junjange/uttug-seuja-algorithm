def solution(arrayA, arrayB):
    numA = calculate(commonDivisor(arrayA), arrayB)
    numB = calculate(commonDivisor(arrayB), arrayA)
    return max(numA + numB)

def divisor(number):
    result = []
    for i in range(1, int(number**(1/2))+1):
        if number%i==0:
            result.append(i)
            if i < number//i:
                result.append(number//i)
                
    return sorted(result) 

def commonDivisor(array):
    numList = [0]
    for i in divisor(min(array))[1:]:
        for j in array:
            if j % i != 0:
                break
        else:
            numList.append(i)
            
    return numList

def calculate(numList, array):
    result = [0]
    if len(numList) == 1:
        return [0]
    for i in numList[1:]:
        for j in array:
            if j % i == 0:
                break
        else:
            result.append(i)
            
    return result
