import sys
from collections import deque

move = {'up': [-1, 0], 'down': [1, 0], 'left': [0, -1], 'right': [0, 1]}
traffic = {
    1: (move['right'], [move['up'], move['right'], move['down']]),
    2: (move['up'], [move['left'], move['up'], move['right']]),
    3: (move['left'], [move['up'], move['left'], move['down']]),
    4: (move['down'], [move['right'], move['down'], move['left']]),
    5: (move['right'], [move['up'], move['right']]),
    6: (move['up'], [move['left'], move['up']]),
    7: (move['left'], [move['left'], move['down']]),
    8: (move['down'], [move['down'], move['right']]),
    9: (move['right'], [move['right'], move['down']]),
    10: (move['up'], [move['up'], move['right']]),
    11: (move['left'], [move['up'], move['left']]),
    12: (move['down'], [move['left'], move['down']])
}

n, t = map(int, sys.stdin.readline().split())
board = [[list(map(int, sys.stdin.readline().split())) for _ in range(n)] for _ in range(n)]
answer = set()
queue = deque([[[0, 0], [-1, 0], 0]])

while queue:
    position, pre_position, nd = queue.popleft()

    if nd > t:
        continue
    
    now_signal = board[position[0]][position[1]][nd%4]
    move = traffic[now_signal]
    answer.add((position[0], position[1]))
    
    if pre_position != move[0]:
        continue
    
    for m in move[1]:
        nx = position[0] + m[0]
        ny = position[1] + m[1]
        if 0 <= nx < n and 0 <= ny < n:
            queue.append([[nx, ny], [m[0], m[1]], nd + 1])
            
print(len(answer))
    
