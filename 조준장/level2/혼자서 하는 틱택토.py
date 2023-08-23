def checkWin(board, k):
    cnt = 0
    for i in range(3):
        if board[0][i] == board[1][i] == board[2][i] == k:
            cnt += 1
            
        if board[i][0] == board[i][1] == board[i][2] == k:
            cnt += 1
        
    if board[0][0] == board[1][1] == board[2][2] == k:
        cnt += 1
    
    if board[2][0] == board[1][1] == board[0][2] == k:
        cnt += 1
    
    return cnt
    
def checkCount(board):
    o = 0
    x = 0

    for i in range(3):
        o += board[i].count('O')
        x += board[i].count('X')
    return o, x
            
    
def solution(board):
    o_cnt, x_cnt = checkCount(board)
    
    if o_cnt + x_cnt == 0:
        return 1
    if o_cnt > x_cnt+1:
        return 0
    if o_cnt < x_cnt:
        return 0
    
    o_win = checkWin(board, 'O') 
    x_win = checkWin(board , 'X')
    
    if x_win == o_win and o_win == 0:
        return 1
    if x_win == 0 and o_win > 0:
        if x_cnt < o_cnt:
            return 1
    if x_win > 0 and o_win == 0:
        if x_cnt == o_cnt:
            return 1
    
    return 0
