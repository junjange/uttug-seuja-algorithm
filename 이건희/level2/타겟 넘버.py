def solution(numbers, target):
    result = 0
    
    def dfs(sumNum, lenNum):
        nonlocal result
        
        if lenNum == len(numbers): 
            if sumNum == target:
                result += 1
            return
        
        num = [-sumNum, sumNum]
        
        if lenNum == 1:
            for i in range(2):
                dfs(num[i] + numbers[lenNum], lenNum + 1)
                dfs(num[i] - numbers[lenNum], lenNum + 1)
        else:
            dfs(sumNum + numbers[lenNum], lenNum + 1)
            dfs(sumNum - numbers[lenNum], lenNum + 1)
            
    dfs(numbers[0], 1)
    return result
