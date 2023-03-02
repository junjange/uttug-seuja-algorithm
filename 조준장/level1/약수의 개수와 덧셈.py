def measure(num):
    nums = 0
    for i in range(1, num+1):
        if num % i == 0:
            nums += 1
            
    if nums % 2 ==0:
        return num
    return -num
            

def solution(left, right):
    answer = 0
    for i in range(left, right+1):
        answer += measure(i)
        
    return answer
