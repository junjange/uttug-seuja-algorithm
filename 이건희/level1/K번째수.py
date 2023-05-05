def solution(array, commands):
    result = []
    for i in commands:
        arr = array[i[0] - 1 : i[1]]
        arr.sort()
        result.append(arr[i[2] - 1])
    return result
