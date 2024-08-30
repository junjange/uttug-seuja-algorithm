import sys


def check_row(graph, str):
    for i in range(3):
        cnt = 0
        for j in range(3):
            if graph[i][j] == str:
                cnt += 1
        if cnt == 3:
            return True
    return False


def check_column(graph, str):
    for i in range(3):
        cnt = 0
        for j in range(3):
            if graph[j][i] == str:
                cnt += 1
        if cnt == 3:
            return True
    return False


def check_diagonal(graph, str):
    if graph[0][0] == graph[1][1] == graph[2][2] == str:
        return True

    if graph[0][2] == graph[1][1] == graph[2][0] == str:
        return True
    return False


def solution(graph, str):
    if check_row(graph, str):
        return True

    if check_column(graph, str):
        return True

    if check_diagonal(graph, str):
        return True
    return False


while True:
    t = str(sys.stdin.readline())
    if t == "end\n":
        break
    cnt_x = 0
    cnt_o = 0
    graph = [[] for _ in range(3)]
    for i in range(3):
        for j in range(3):
            word = t[(i * 3) + j]
            graph[i].append(word)
            if word == "O":
                cnt_o += 1
            elif word == "X":
                cnt_x += 1

    if cnt_x < cnt_o:
        print("invalid")
        continue

    if cnt_o + 1 < cnt_x:
        print("invalid")
        continue

    if cnt_x == cnt_o:
        if solution(graph, "O") and not solution(graph, "X"):
            print("valid")
            continue

    if cnt_x == cnt_o + 1:
        if solution(graph, "X") and not solution(graph, "O"):
            print("valid")
            continue

    if cnt_x == 5 and cnt_o == 4:
        if not solution(graph, "X") and not solution(graph, "O"):
            print("valid")
            continue

    print("invalid")
