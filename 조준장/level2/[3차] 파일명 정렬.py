def solution(files):
    answer = []
    file = []
    
    for i in range(len(files)):
        head = ""
        number = ""
        flag = False
        for j in files[i]:
            if j.isdigit():
                number += j
                flag = True
            else:
                if flag:
                    break
                if j.isalpha():
                    head += j.lower()
                    
                else:
                    head += j
                
        file.append([files[i], head, number, i])
    
    file.sort(key=lambda x:(x[1], int(x[2]), x[3]))

    for f in file:
        answer.append(f[0])

    return answer
