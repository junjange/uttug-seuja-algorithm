def solution(price, money, count):
    result = price * (count * (count + 1) // 2)
    if money < result:
        return result - money
    return 0
