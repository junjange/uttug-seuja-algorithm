from collections import deque

def solution(order):
    result = 0
    save = deque()

    for i in range(1, len(order) + 1):
        save.appendleft(i)
        for j in range(len(save)):
            if save[0] == order[result]:
                save.popleft()
                result += 1
            else:
                break
        
    return result
