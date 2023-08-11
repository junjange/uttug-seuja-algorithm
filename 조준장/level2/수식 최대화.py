from itertools import permutations


def operation(num1, num2, op):
    if op == '+':
        return str(int(num1) + int(num2))
    elif op == '-':
        return str(int(num1) - int(num2))
    elif op == '*':
        return str(int(num1) * int(num2))
    
def calculate(exp,op):
    exp = exp.replace("*", "/*/").replace("-", "/-/").replace("+", "/+/").split("/")

    for o in op:
        stack=[]
        while len(exp)!=0:
            temp=exp.pop(0)
            if temp==o:
                stack.append(operation(stack.pop(), exp.pop(0), o))
                continue
            stack.append(temp)
            
        exp = stack

    return abs(int(exp[0]))

def solution(expression):
    answer = 0
    operator = ['+', '-', '*']
    for op in permutations(operator, 3):
        answer = max(answer, calculate(expression, op))
    
    return answer
