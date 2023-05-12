def solution(name, yearning, photo):
    result = []
    for i in range(len(photo)):
        cnt = 0
        for j in range(len(photo[i])):
            if photo[i][j] in name:
                cnt += yearning[name.index(photo[i][j])]
        result.append(cnt)

    return result
