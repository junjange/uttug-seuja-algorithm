def solution(board):
    lineO = 0
    lineX = 0
    cntO, cntX = sum([arr.count('O') for arr in board]), sum([arr.count('X') for arr in board])
                
    box = [[board[0][0], board[1][1], board[2][2]], [board[0][2], board[1][1], board[2][0]]]
    
    for i in range(3):
        box.append((board[i]))
        box.append([board[0][i], board[1][i], board[2][i]])
        
    for i in box:
        if ''.join(map(str,i)) == 'OOO':
            lineO += 1
        elif ''.join(map(str,i)) == 'XXX':
            lineX += 1
            
    if lineO and lineX:
        return 0
    if lineO and cntO == cntX:
        return 0 
    if lineX and cntO != cntX:
        return 0
    if cntO - cntX < 0 or 1 < cntO - cntX:
        return 0
    return 1
