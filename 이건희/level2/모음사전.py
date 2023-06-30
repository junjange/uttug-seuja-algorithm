def solution(word):
    result = 0
    words = ['A', 'E', 'I', 'O', 'U']
    order = [781, 156, 31, 6, 1]
    
    for i in range(len(word)):
        num = words.index(word[i])
        result += order[i] * num
        
    return result + len(word)
