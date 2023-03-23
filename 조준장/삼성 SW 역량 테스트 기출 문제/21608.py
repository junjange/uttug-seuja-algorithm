import sys


n = int(sys.stdin.readline())
students = [list(map(int, sys.stdin.readline().split())) for _ in range(n**2)]
graph = [[0 for _ in range(n)] for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for s in students:
    student_num = s[0]
    student_like_num = s[1::]
    space = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 0:
                like = 0
                blank = 0
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if 0 <= nx < n and 0 <= ny < n:
                        if graph[nx][ny] in student_like_num:
                            like += 1
                        if graph[nx][ny] == 0:
                            blank += 1
                space.append([i, j, like, blank])

    space.sort(key=lambda x:(-x[2], -x[3], x[0], x[1]))
    graph[space[0][0]][space[0][1]] = student_num

answer = 0
students.sort()

for i in range(n):
    for j in range(n):
        cnt = 0
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            if 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] in students[graph[i][j]-1][1::]:
                    cnt += 1
        if cnt != 0:
            answer += 10 ** (cnt-1)
print(answer)
