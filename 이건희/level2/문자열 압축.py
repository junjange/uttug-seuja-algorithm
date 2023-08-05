def solution(s):
    result = len(s)
    len_s = len(s)
    
    for i in range(1, len(s) // 2 + 1):
        box = [s[j:j+i] for j in range(0, len(s), i)]
        len_s = len(s)
        cnt = 1

        for j in range(len(box)):
            if j == len(box) - 1:
                if cnt > 1:
                    len_s -= i * cnt
                    len_s += i + len(str(cnt))
            else:
                if box[j] == box[j + 1]:
                    cnt += 1
                elif cnt > 1:
                    len_s -= i * cnt
                    len_s += i + len(str(cnt))
                    cnt = 1
        
        result = min(result, len_s)
        
    return result
