def solution(numbers, hand):
    result = ''
    left_hand = 10 
    right_hand = 12

    for i in numbers:
        if i in [1, 4, 7]:
            left_hand = i
            result += 'L'
        elif i in [3, 6, 9]:
            right_hand = i
            result += 'R'
        else:
            if i == 0:
                i = 11
            left_num = abs(i - left_hand)
            left_cnt = left_num // 3 + left_num % 3
            right_num = abs(i - right_hand)
            right_cnt = right_num // 3 + right_num % 3

            if left_cnt < right_cnt:
                left_hand = i
                result += 'L'
            elif left_cnt > right_cnt:
                right_hand = i
                result += 'R'
            else:
                if hand == "left":
                    left_hand = i
                    result += 'L'
                else:
                    right_hand = i
                    result += 'R'

    return result
