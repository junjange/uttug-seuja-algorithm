def buy(users, emoticons, discount):
    number = 0
    sale_price = 0
    for rate, price in users:
        new_sale_price = 0
        for i in range(len(emoticons)):
            if rate <= discount[i]:
                new_sale_price += emoticons[i] * (100-discount[i]) * 0.01
        
        if new_sale_price >= price:
            number += 1
        else:
            sale_price += new_sale_price
    return number, sale_price
                


def backtracking(users, emoticons, discount, start):
    global answer
    
    if start == len(emoticons) == len(discount):
        number, sale_price = buy(users, emoticons, discount)
        if answer[0] < number:
            answer[0] = number
            answer[1] = sale_price
        elif answer[0] == number:
            if answer[1] < sale_price:
                answer[1] = sale_price
        return
    
    for k in [40, 30, 20, 10]:
        for i in range(start, len(emoticons)):
            discount.append(k)
            backtracking(users, emoticons, discount, i+1)
            discount.pop()
        

answer = [0, 0]
def solution(users, emoticons):
    backtracking(users, emoticons, [], 0)
    return answer
