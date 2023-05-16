def solution(n, m, section):
    result = 0
    current = section[0] - 1

    for i in section:
        if current < i:
            current = i + m - 1
            result += 1

    return result
