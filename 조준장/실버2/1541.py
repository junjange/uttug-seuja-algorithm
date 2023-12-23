n = list(map(str, input().split('-')))
answer = 0
temp = []
for i in n:
    sum_num = 0
    for j in i.split('+'):
        sum_num += int(j)

    temp.append(sum_num)

    answer = temp[0]
    for k in range(1, len(temp)):
        answer -= temp[k]

print(answer)
