def quad_check(arr, q, i, j):
    target = arr[i][j]
    for x in range(i, i+q):
        for y in range(j, j+q):
            if arr[x][y] != target:
                return False
    return True

def quad_visited(visited, arr, q, i, j):
    for x in range(i, i+q):
        for y in range(j, j+q):
            visited[x][y] = True
    return visited

def solution(arr):
    answer = [0, 0]
    n = len(arr)
    quad = []
    while n != 1:
        quad.append(n)
        n //= 2

    visited = [[False]*len(arr) for _ in range(len(arr))]
    for q in quad:
        for i in range(0, len(arr), q):
            for j in range(0, len(arr), q):
                if not visited[i][j]:
                    if quad_check(arr, q, i, j):
                        if arr[i][j] == 0:
                            answer[0] += 1
                        else:
                            answer[1] += 1
                        visited = quad_visited(visited, arr, q, i, j)
    
    for x in range(len(arr)):
        for y in range(len(arr)):
            if not visited[x][y]:
                if arr[x][y] == 0:
                    answer[0] += 1
                else:
                    answer[1] += 1 
    
    return answer
