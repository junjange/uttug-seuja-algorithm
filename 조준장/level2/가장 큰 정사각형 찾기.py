def solution(board):
    answer = 0
    
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 1:
                board[i][j] = min(board[i-1][j], board[i][j-1], board[i-1][j-1]) + 1
    
    for k in board:
        answer = max(answer, max(k))
    
    return answer**2
