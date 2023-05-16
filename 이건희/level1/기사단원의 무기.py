def solution(number, limit, power):
    result = []

    for i in range(1, number + 1):
        num = 0
        for j in range(1, int(i**(1/2)) + 1):
            if (i % j == 0):
                num += 1
                if ( (j**2) != i) : 
                    num += 1

        if num > limit:
            result.append(power)
        else:
            result.append(num)

    return sum(result)
