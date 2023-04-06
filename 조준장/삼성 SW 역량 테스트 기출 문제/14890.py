import sys


def road_check(road):
    visited = [False for _ in range(N)]
    for i in range(1, N):

        if abs(road[i] - road[i - 1]) > 1:
            return False

        # 경사가 낮을 경우
        if road[i-1] > road[i]:
            for k in range(L):
                if i + k >= N or visited[i + k] or road[i] != road[i + k]:
                    return False
                visited[i + k] = True

        # 경사가 높을 경우
        elif road[i-1] < road[i]:
            for k in range(L):
                if i - k - 1 < 0 or visited[i - k - 1] or road[i - 1] != road[i - k - 1]:
                    return False
                visited[i - k - 1] = True

    return True


N, L = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
answer = 0

for i in range(N):
    if road_check(graph[i]):
        answer += 1

    new_road = []
    for j in range(N):
        new_road.append(graph[j][i])

    if road_check(new_road):
        answer += 1

print(answer)
