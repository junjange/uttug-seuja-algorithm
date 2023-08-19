def timeToInt(start):
    start = start.split(":")
    return int(start[0]) * 60 + int(start[1])
    
def timeRemaining(time, answer, stack):
    while stack:
        pre_plan = stack.pop()
                    
        if pre_plan[2] <= time:
            time -= pre_plan[2]
            answer.append(pre_plan[0])
                        
        else:
            pre_plan[2] -= time
            stack.append(pre_plan)
            return


def solution(plans):
    answer = []
    
    for i in range(len(plans)):
        name, start, playtime = plans[i]
        plans[i][1] = timeToInt(start)
        plans[i][2] = int(playtime)
    
    plans.sort(key=lambda x : -x[1])
    stack = []

    while True:
        if len(plans) == 1:
            answer.append(plans[0][0])
            break
        
        plan = plans.pop()
        
        if plan[1] + plan[2] <= plans[-1][1]:
            answer.append(plan[0])
            
            if plan[1] + plan[2] < plans[-1][1]:
                time = plans[-1][1] - (plan[1] + plan[2])
                timeRemaining(time, answer, stack)
                
        else:
            stack.append([plan[0], plans[-1][1], plan[2] - (plans[-1][1] - plan[1])])
                    
    while stack:
        answer.append(stack.pop()[0])
    
    return answer
