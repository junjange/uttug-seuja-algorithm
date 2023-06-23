def solution(msg):
    result = []
    alpha = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    cnt = 0
    word = msg[0]
    
    while cnt != len(msg):
        if word in alpha:
            if cnt != len(msg) - 1:
                cnt += 1
            else:
                result.append(alpha.index(word) + 1)
                break
            word += msg[cnt]
        else:
            result.append(alpha.index(word[:-1]) + 1)
            alpha.append(word)
            word = msg[cnt]
            
    return result
