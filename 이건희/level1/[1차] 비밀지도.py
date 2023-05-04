def solution(n, arr1, arr2):
    result = []
    for i in range(n):
        a = bin(arr1[i] | arr2[i])[2:].zfill(n)
        b = a.replace("1", "#").replace("0", " ")
        result.append(b)
    return result
