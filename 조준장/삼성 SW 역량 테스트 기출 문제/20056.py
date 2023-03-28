import sys

"""
파이어볼은 위치(r, c), 질량, 방향, 속도를 갖는다.
격자의 행과 열은 1번부터 n번까지 번호가 매겨져 있고 1번 행은 n번과 연결되어 있고, 1번 열은 n번 열과 연결되어 있다.
파이어볼의 방향은 어떤 칸과 인접한 8개의 칸의 방향을 의미한다.
모드 파이어볼이 자신의 방향 d로 속력 s칸 만큼 이동한다.
이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 발생한다.
    1. 같은 칸에 있는 파이어볼은 모두 하나가 된다.
    2. 파이어볼은 4개의 파이어볼로 나누어진다.
    3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
    4. 질량이 0인 파이어볼은 소멸되어 없어진다.
마법사 상어가 이동을 k번 명령한 후, 남아있는 파이어볼 질량의 합을 구해보자.
"""

n, m, k = map(int, sys.stdin.readline().split())
orders = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
graph = [[[] for _ in range(n)] for _ in range(n)]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

for _ in range(k):
    while orders:
        sx, sy, sm, ss, sd = orders.pop()

        nx = (sx + dx[sd] * ss) % n
        ny = (sy + dy[sd] * ss) % n

        graph[nx][ny].append([sm, ss, sd])

    for i in range(n):
        for j in range(n):
            if len(graph[i][j]) > 1:
                sum_sm = 0
                sum_ss = 0
                cnt_odd = 0
                cnt_even = 0
                cnt = len(graph[i][j])
                while graph[i][j]:
                    k = graph[i][j].pop()
                    sum_sm += k[0]
                    sum_ss += k[1]
                    if k[2] % 2:
                        cnt_odd += 1
                    else:
                        cnt_even += 1

                if cnt_odd == cnt or cnt_even == cnt:
                    nd = [0, 2, 4, 6]
                else:
                    nd = [1, 3, 5, 7]

                if sum_sm // 5:
                    for d in nd:
                        orders.append([i, j, sum_sm // 5,  sum_ss // cnt, d])

            if len(graph[i][j]) == 1:
                orders.append([i, j] + graph[i][j].pop())

print(sum([o[2] for o in orders]))
