def alphabet(name):
    point = 0
    for n in name:
        point += min(ord(n) - ord('A'), ord('Z') - ord(n)+1)        
    return point

def move(name):
    min_move = len(name) - 1
    
    for i in range(len(name)):
        
        next = i + 1
        
        while next < len(name) and name[next] == 'A':
            next += 1
        min_move = min(min_move, 2 * i + len(name) - next, 2 * (len(name) - next) + i)
        
    return min_move
    

def solution(name):
    return alphabet(name) + move(name)
