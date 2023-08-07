from itertools import combinations

def solution(places):
    result = []
    place = []

    for i in range(5):
        box = []
        flag = 0
        for j in range(5):
            for k in range(5):
                if places[i][j][k] == 'P':
                    box.append([i, j, k])
        place.append(box)
    
    for i in place:
        flag = 0
        per = list(combinations(i, 2))
        for j in per:
            r = j[0]
            c = j[1]
            num = abs(r[1] - c[1]) + abs(r[2] - c[2])
            
            if num == 1:
                flag = 1
                break
            elif num == 2:
                if abs(r[1] - c[1]) == 2 and r[2] == c[2]:
                    if places[r[0]][max(r[1], c[1]) - 1][r[2]] == "O":
                        flag = 1
                        break
                elif r[1] == c[1] and abs(r[2] - c[2]) == 2:
                    if places[r[0]][r[1]][max(r[2], c[2]) - 1] == "O":
                        flag = 1
                        break
                else:
                    if places[r[0]][r[1]][c[2]] == "O" or places[r[0]][c[1]][r[2]] == "O":
                        flag = 1
                        break
                        
        result.append(0 if flag else 1)
        
    return result
