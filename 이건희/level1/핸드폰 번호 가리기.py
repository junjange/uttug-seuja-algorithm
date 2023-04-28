def solution(phone_number):
    result = list(phone_number)
    for i in range(len(result) - 4):
        result[i] = "*"

    return ''.join(map(str, result))
