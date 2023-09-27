def solution(s):
    answer = []
    for s_item in s:
        stack = []
        cnt = 0
        idx = 0
        
        while len(s_item) > idx:
            if "".join(stack[-2:]) == "11" and s_item[idx] == "0":
                del stack[-1]
                del stack[-1]
                cnt += 1
            else:
                stack.append(s_item[idx])
            idx += 1
                    
        for i in range(-1, -len(stack)-1, -1):
            if stack[i] == "0":
                answer.append(''.join(stack[:len(stack) + i+1]) + '110' * cnt + '1' * (-i-1))
                break
        else:
            answer.append('110' * cnt + ''.join(stack[:len(stack)]) )
            
    return answer
