def solution(numbers):
    result = []
    
    for i in numbers:
        if i % 2 == 0:
            result.append(i + 1)
        else:
            num =  format(i, 'b')

            if num.count('0') > 0:
                index = num[::-1].find('0')
                num1 = '1' + '0' * (index)
            else:
                num1 = '1' + '0' * len(num)

            result.append(int(num, 2) + int(num1, 2) // 2)
            
    return result
