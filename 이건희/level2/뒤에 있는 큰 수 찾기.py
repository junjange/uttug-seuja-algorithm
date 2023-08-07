def solution(numbers):
    result = [-1] * len(numbers)
    stack = []

    for i, number in enumerate(numbers):
        while stack and numbers[stack[-1]] < number:
            result[stack.pop()] = number

        stack.append(i)

    return result
