def solution(keymap, targets):
    answer = []
    
    for target in targets:
        cnt = 0
        for t in target:
            key_idx = []
            for k in keymap:
                if t in k:
                    key_idx.append(k.index(t))
            if not key_idx:
                cnt = -1
                break
            cnt += min(key_idx)+1
        answer.append(cnt)
    
    
    return answer
