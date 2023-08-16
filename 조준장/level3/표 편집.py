class Node() :
    def __init__(self,left = None,right = None):
        self.state = False
        self.left = left
        self.right = right

def U_X(table, x, k):
    for _ in range(int(x)):
        k = table[k].left
    return k

def D_X(table, x, k):
    for _ in range(int(x)):
        k = table[k].right
    return k

def C(table, k, stack):
    stack.append(k)
    table[k].state = True

    left  = table[k].left 
    right = table[k].right

    if left or left == 0:
        table[left].right = right
    
    if right:
        table[right].left = left
        k = right
    else:
        k = left
    return k

def Z(table, k, stack):
    idx = stack.pop()
    table[idx].state = False

    left = table[idx].left
    right = table[idx].right
    
    if left:
        table[left].right = idx
    if right:
        table[right].left = idx
        
        
def solution(n, k, cmd):
    table = [Node(i-1,i+1) for i in range(n)]
    table[0].left= None
    table[n - 1].right = None
    stack = []
    
    for c in cmd:
        c = c.split(" ")
        if c[0] == 'U':
            k = U_X(table, c[1], k)
            
        elif c[0] == 'D':
            k = D_X(table, c[1], k)
            
        elif c[0] == 'C':
            k = C(table, k, stack)
        else:
            Z(table, k, stack)
            
    answer = ""
    for i in range(n):
        if table[i].state :
            answer += "X"
        else:
            answer += "O"
    return answer
