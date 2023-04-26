def solution(n):
    result = []
    for i in str(n):
        result.append(i)
    result.sort(reverse = True)
    result = "".join(result)
    return int(result)
