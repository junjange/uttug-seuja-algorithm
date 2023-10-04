from collections import deque
    
def solution(s):
    result = 0
    s = deque(s)

    for _ in range(len(s)):
        s.rotate()
        bracket = ''.join(s)

        while True:
            lenNum = len(bracket)
            bracket = bracket.replace("()", "")
            bracket = bracket.replace("{}", "")
            bracket = bracket.replace("[]", "")
            
            if len(bracket) == 0:
                result += 1
                break
            if len(bracket) == lenNum:
                break
    
    return result
