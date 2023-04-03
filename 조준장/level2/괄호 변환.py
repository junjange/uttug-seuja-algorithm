def 올바른_문자열인지_확인(p):
    stack = []
    for i in  p:
        if stack and stack[-1] == "(" and i == ")" :
            stack.pop()
        else:
            stack.append(i)
    
    if stack:
        return False
    return True

def u와v_분리(p):
    left = 0
    right = 0
    for i in range(len(p)):
        if p[i] == ")":
            left += 1
        else:
            right += 1
        
        if left == right:
            # u, v 분리
            u = p[:i+1]
            v = p[i+1:]
            
            if 올바른_문자열인지_확인(u): return u + u와v_분리(v)
            return "(" + u와v_분리(v) + ")" + 올바른_문자열_만들기(u) 
        
    return ""

def 올바른_문자열_만들기(u):
    print(u.sprit())
    print(u.lstrip().rstrip())
    return 괄호_방향_뒤집기(u.lstrip().rstrip())

def 괄호_방향_뒤집기(u):
    U = ""
    for i in u:
        if i == ")":
            U += "("
        else:
            U += ")"
    return U

def solution(p):
    if 올바른_문자열인지_확인(p): return p
    return u와v_분리(p)
