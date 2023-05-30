def solution(sequence):
    n = len(sequence)
    purse_plus_sequence = []
    purse_minus_sequence = []

    for i in range(n):
        if i % 2 == 0:
            purse_plus_sequence.append(sequence[i])
            purse_minus_sequence.append(-sequence[i])
        else:
            purse_plus_sequence.append(-sequence[i])
            purse_minus_sequence.append(sequence[i])
        
    purse_plus_dp = [purse_plus_sequence[0]]
    purse_minus_dp = [purse_minus_sequence[0]]

    
    for i in range(n-1):
        purse_plus_dp.append(max(purse_plus_dp[i] + purse_plus_sequence[i+1], purse_plus_sequence[i+1]))
        purse_minus_dp.append(max(purse_minus_dp[i] + purse_minus_sequence[i+1], purse_minus_sequence[i+1]))

    return max(max(purse_plus_dp), max(purse_minus_dp))
