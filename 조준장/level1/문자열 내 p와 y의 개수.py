from collections import Counter

def solution(s):
    s = Counter(s)
    
    if s["p"] + s["P"] == s["y"] + s["Y"]:
        return True
    return False
