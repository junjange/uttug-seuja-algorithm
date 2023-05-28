def solution(n):
    result = 0
    F_num = [0, 1]

    for i in range(n - 1):
        F_num.append(F_num[-1] + F_num[-2])

    return F_num[-1] % 1234567
