import copy


def check(new_lock):
    n = len(new_lock) // 3
    for i in range(n, n * 2):
        for j in range(n, n * 2):
            if new_lock[i][j] != 1:
                return False
    return True


def key_lock(key, lock, new_lock):
    for i in range(1, len(lock)*2):
        for j in range(1, len(lock)*2):
            for x in range(len(key)):
                for y in range(len(key)):
                    new_lock[i+x][j+y] += key[x][y]
            
            if check(new_lock):
                return True
            
            for x in range(len(key)):
                for y in range(len(key)):
                    new_lock[i + x][j + y] -= key[x][y]
            
    return False
                    

def solution(key, lock):
    
    new_lock = [[0 for _ in range(len(lock) * 3)] for _ in range(len(lock)* 3)]
    for i in range(len(lock)):
        for j in range(len(lock)):
            new_lock[len(lock) + i][len(lock)  + j] += lock[i][j]
                
    for _ in range(4):
        new_key = []
        for i in range(len(key)):
            temp_key = []
            for j in range(len(key)):
                temp_key.append(key[j][i])
            new_key.append(temp_key[::-1])
            
        key = copy.deepcopy(new_key)
        if key_lock(key, lock, new_lock):
            return True
    return False
