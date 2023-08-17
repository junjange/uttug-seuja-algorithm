from itertools import product

def solution(users, emoticons):
    result = [0, 0]
    dis = [10, 20, 30, 40]
    
    def check(users, emoticons, dis):
        sub, total_money = 0, 0
        
        for i, j in users:
            money = 0
            for e, d in zip(emoticons, dis):
                if i <= d:
                    money += e * (100 - d) // 100
            if j <= money:
                sub += 1
            else:
                total_money += money
        return [sub, total_money]
    
    for i in product(dis, repeat=len(emoticons)):
        current = check(users, emoticons, i)
        if result[0] < current[0]:
            result = current
        elif result[0] == current[0]:
            if result[1] < current[1]:
                result = current
                
    return result
