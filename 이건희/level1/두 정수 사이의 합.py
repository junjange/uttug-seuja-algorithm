if(a == b):
        return a
    mn = max(abs(a), abs(b))
    nn = min(abs(a), abs(b))
    
    if((mn - nn) % 2 == 0):
        return (a + b) * (mn - nn + 1) / 2
    return (a + b) * (mn - nn - 1)
