def solution(x):
    result = list(str(x))
    if(x % sum(list(map(int, result))) == 0):
        return True
    return False
