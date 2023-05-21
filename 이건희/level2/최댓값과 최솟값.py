def solution(s):

    result = list(map(int, s.split()))

    return str(min(result)) + " " + str(max(result))
