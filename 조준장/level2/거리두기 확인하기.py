def bfs(graph):
    dx = [1, -1, 0, 0, 2, -2, 0, 0, -1, -1, 1, 1]
    dy = [0, 0, 1, -1, 0, 0, 2, -2, 1, -1, 1, -1]
    for x in range(5):
        for y in range(5):
            if graph[x][y] == "P":
    
                for i in range(12): # 아래/위/오/왼/아래2/위2/오2/왼2/위우대각선/위왼대각선/아래우대각선/아래왼대각선
                    nx = x + dx[i]
                    ny = y + dy[i]

                    if 0 <= nx < 5 and 0 <= ny < 5:
                        if i in [0, 1, 2, 3]:
                            if graph[nx][ny] == "P":
                                return 0
                        
                        if i == 4:
                            if graph[nx][ny] == "P" and graph[nx-1][ny] == "O":
                                return 0
                            
                        if i == 5:
                            if graph[nx][ny] == "P" and graph[nx+1][ny] == "O":
                                return 0
                        
                        if i == 6:
                            if graph[nx][ny] == "P" and graph[nx][ny-1] == "O":
                                return 0
                        
                        if i == 7:
                            if graph[nx][ny] == "P" and graph[nx][ny+1] == "O":
                                return 0

                        if i == 8:
                            if graph[nx][ny] == "P" and (graph[x-1][y] != "X" or graph[x][y+1] != "X"):
                                return 0

                        if i == 9:
                            if graph[nx][ny] == "P" and (graph[x-1][y] != "X" or graph[x][y-1] != "X"):
                                return 0

                        if i == 10:
                            if graph[nx][ny] == "P" and (graph[x+1][y] != "X" or graph[x][y+1] != "X"):
                                return 0

                        if i == 11:
                            if graph[nx][ny] == "P" and (graph[x+1][y] != "X" or graph[x][y-1] != "X"):
                                return 0
                        
    return 1


def solution(places):
    return [bfs(place) for place in places]
