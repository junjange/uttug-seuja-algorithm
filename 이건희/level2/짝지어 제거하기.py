def solution(s):
    num_list = []

    for i in s:
        if len(num_list) == 0:
            num_list.append(i)
        else:
            if num_list[-1] == i:
                num_list.pop()
            else:
                num_list.append(i)

    if len(num_list) == 0:
        return 1
    else:
        return 0
