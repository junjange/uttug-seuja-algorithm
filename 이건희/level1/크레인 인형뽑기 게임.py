def solution(board, moves):
    result = 0
    dolls = []

    for i in moves:
        for j in range(len(board[0])):
            if board[j][i - 1] == 0:
                pass
            else:
                dolls.append(board[j][i - 1])
                board[j][i - 1] = 0
                break
        if len(dolls) >= 2 and dolls[-1] == dolls[-2]:
            dolls.pop()
            dolls.pop()
            result += 2

    return result
