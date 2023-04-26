def solution(n):
    result = n ** 0.5
    if(int(result) == result):
        return (result + 1) ** 2
    return -1
