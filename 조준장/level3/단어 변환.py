from collections import deque

# 한 번에 한 개의 알파벳만 바꿨을 때 가능한 단어
def change_word(x, y):
    cnt = 0        
    for i in range(len(x)):
        if x[i] != y[i]:
            cnt += 1
            
    if cnt == 1:
        return True
    return False

def solution(begin, target, words):
    
    if target not in words:
        return 0
    
    answer = 1e9
    n = len(words)
    visited = [False] * n
    queue = deque([[begin, 0]])

    while queue:
        word, cnt = queue.popleft()
    
        if word == target:
            answer = min(answer, cnt)
            
        for i in range(n):
            if change_word(word, words[i]) and not visited[i]:
                visited[i] = True
                queue.append([words[i], cnt+1])
    
    return answer
