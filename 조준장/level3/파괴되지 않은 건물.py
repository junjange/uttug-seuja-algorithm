def solution(board, skill):
    answer = 0
    n, m = len(board), len(board[0])
    new_board = [[0 for _ in range(m+1)] for _ in range(n+1)]

    for s in skill:
        types, r1, c1, r2, c2, degree = s

        if types == 1: types = -1
        else: types = 1
        
        new_board[r1][c1] += degree*types
        new_board[r1][c2+1] -= degree*types
        new_board[r2+1][c1] -= degree*types
        new_board[r2+1][c2+1] += degree*types
        
    for i in range(n):
        for j in range(1, m):
            new_board[i][j] += new_board[i][j-1]

    for i in range(m):
        for j in range(1,n):
            new_board[j][i] += new_board[j-1][i]

    for i in range(n):
        for j in range(m):    
            board[i][j] += new_board[i][j]
            if board[i][j] > 0:
                answer += 1
    
    return answer
    
