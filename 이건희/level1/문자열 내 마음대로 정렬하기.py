def solution(strings, n):
    result = []
    for i in range(len(strings)):
        strings[i] = strings[i][n] + strings[i]
    strings.sort()

    for i in range(len(strings)):
        result.append(strings[i][1:])
    return result
