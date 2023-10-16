T = int(input())
num = [2, 3, 5, 7, 11]
for i in range(1, T + 1):
    result = [0, 0, 0, 0, 0]
    n = int(input())
    for j in range(5):
        while n % num[j] == 0:
            n /= num[j]
            result[j] += 1
    a, b, c, d, e = result            
    print(f"#{i} {a} {b} {c} {d} {e}")
