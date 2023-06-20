def solution(record):
    result = []
    save_keyword = []
    save_nickname = {}
    
    for i in record:
        split_list = list(i.split(' '))
        if split_list[0] == "Enter":
            save_keyword.append([split_list[0], split_list[1]])
            save_nickname[split_list[1]] = split_list[2]
        elif split_list[0] == "Leave":
            save_keyword.append([split_list[0], split_list[1]])
        else:
            save_nickname[split_list[1]] = split_list[2]

    for i in save_keyword:
        if i[0] == "Enter":
            result.append(save_nickname[i[1]] + "님이 들어왔습니다.")
        else:
            result.append(save_nickname[i[1]] + "님이 나갔습니다.")
    
    return result
