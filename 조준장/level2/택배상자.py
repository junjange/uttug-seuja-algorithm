from collections import deque

def solution(order):
    answer = 0
    n = len(order)
    box = deque([i for i in range(1, n+1)])
    order = deque(order)
    stack = deque([])
    
    for _ in range(n*4):
        if not stack and not order and not box:
            break
            
        if order and box and order[0] == box[0]:
            box.popleft()
            order.popleft()
            answer += 1
        elif stack and order and stack[-1] == order[0]:
            order.popleft()
            stack.pop()
            answer += 1
        else:
            if box:
                stack.append(box.popleft())

    return answer
