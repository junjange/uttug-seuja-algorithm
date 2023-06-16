def solution(str1, str2):
    str1_list = []
    str2_list = []
    intersection_num = []
    union_num = []
    
    for i in range(len(str1) - 1):
        if str1[i:i + 2].isalpha() == True:
            str1_list.append(str1[i:i + 2].lower())
        
    for i in range(len(str2) - 1):
        if str2[i:i + 2].isalpha() == True:
            str2_list.append(str2[i:i + 2].lower())
    
    for i in set(str1_list + str2_list):
        min_num = min(str1_list.count(i), str2_list.count(i))
        max_num = max(str1_list.count(i), str2_list.count(i))
        intersection_num.append(min_num)
        union_num.append(max_num)
        
    if sum(intersection_num) == 0 and len(union_num) == 0:
        return 65536
    elif sum(intersection_num) == 0 and len(union_num) == 0:
        return 0
    return int((sum(intersection_num) / sum(union_num)) * 65536)
