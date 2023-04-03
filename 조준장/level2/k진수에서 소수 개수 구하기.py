def nbase_to_kbase(n, k):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, k)
        rev_base += str(mod)

    return rev_base[::-1] 
    # 역순인 진수를 뒤집어 줘야 원래 변환 하고자하는 base가 출력

def find_prime_number(num):
    if "0" not in num:
        if is_prime_number(int(num)):
            return 1
        return 0
            
    answer = 0
    num = num.split("0")
    for n in num:
        if n == "":
            continue
        if(is_prime_number(int(n))):
            answer += 1
    return answer
            
    
# 소수 판별 함수
def is_prime_number(x):
    if x == 1: return False
    # 2부터 (x - 1)까지의 모든 수를 확인하며
    for i in range(2, int(x**(0.5))+1):
        # x가 해당 수로 나누어떨어진다면
        if x % i == 0:
            return False # 소수가 아님
    return True # 소수임
        
    
def solution(n, k):
    num = nbase_to_kbase(n, k)
    return find_prime_number(num)
