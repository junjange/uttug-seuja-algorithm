def solution(A,B):
    result = 0

    A.sort()
    B.sort(reverse = True)

    for i, j in zip(A, B):
        result += i * j

    return result
