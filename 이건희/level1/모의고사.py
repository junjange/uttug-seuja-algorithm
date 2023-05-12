def solution(answers):
    result = []
    score = [0, 0, 0]
    student_1 = [1, 2, 3, 4, 5]
    student_2 = [2, 1, 2, 3, 2, 4, 2, 5]
    student_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    for i, answer in enumerate(answers):
        if answer == student_1[i % len(student_1)]:
            score[0] += 1
        if answer == student_2[i % len(student_2)]:
            score[1] += 1
        if answer == student_3[i % len(student_3)]:
            score[2] += 1

    for i, s in enumerate(score):
        if s == max(score):
            result.append(i + 1)

    return result
