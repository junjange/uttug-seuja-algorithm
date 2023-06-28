def solution(survey, choices):
    result = ""
    category = {"R" : 0, "T" : 0, "C" : 0, "F" : 0, "J" : 0, "M" : 0, "A" : 0, "N" : 0}
    
    for i in range(len(survey)):
        if choices[i] == 4:
            continue
        elif choices[i] >= 5:
            score = choices[i] - 4
            category[survey[i][1]] += score
        else:
            score = abs(choices[i] - 4)
            category[survey[i][0]] += score
    
    result += 'R' if category['R'] >= category['T'] else 'T'
    result += 'C' if category['C'] >= category['F'] else 'F'
    result += 'J' if category['J'] >= category['M'] else 'M'
    result += 'A' if category['A'] >= category['N'] else 'N'
    
    return result
