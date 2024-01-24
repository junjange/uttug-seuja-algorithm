import sys


def make_board(key):
    words = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
    board = [["" for _ in range(5)] for _ in range(5)]
    key = list(set(key + words))
    for i in range(5):
        for j in range(5):
            board[i][j] = key[(i * 5) + j]

    return board


def message_split(message):
    while True:
        moved = 0
        for i in range(0, len(message), 2):
            if i + 1 >= len(message):
                break
            if message[i] == message[i + 1]:
                moved += 1
                if message[i] == "X":
                    message.insert(i + 1, "Q")
                else:
                    message.insert(i + 1, "X")
        
        if moved == 0: 
            break
            
    if len(message) % 2 != 0:
        message.append("X")

    group_message = []
    for i in range(0, len(message), 2):
        group_message.append([message[i], message[i + 1]])
    return group_message


def solution(board, message):
    answer = ""
    for m in message:
        first = m[0]
        secnod = m[1]
        falg = False
        for i in range(5):
            if falg: break
            for j in range(5):
                if falg: break

                if board[i][j] == secnod:
                    falg = True
                    # 1
                    if first in board[i]:
                        first_j = 0
                        for k in range(5):
                            if first == board[i][k]:
                                first_j = k
                                break
                                
                        answer += board[i][(first_j + 1) % 5] + board[i][(j + 1) % 5]
                    # 2
                    elif first in board[0][j] or first in board[1][j] or first in board[2][j] or first in board[3][j] or first in board[4][j]:
                        first_i = 0
                        for k in range(5):
                            if first == board[k][j]:
                                first_i = k
                                break
                            
                        answer += board[(first_i + 1) % 5][j] +  board[(i + 1) % 5][j]
                    # 3
                    else:
                        for first_i in range(5):
                            if first in board[first_i]:
                                for second_j in range(5):
                                    if first == board[first_i][second_j]:
                                        answer += board[first_i][j] + board[i][second_j]
                                        break
                                break
                          
    return answer
    
message = list(map(str, sys.stdin.readline().strip()))
key = list(map(str, sys.stdin.readline().strip()))
board = make_board(key)
message = message_split(message)
print(solution(board, message))
