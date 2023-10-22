T = int(input())
for test_case in range(1, T + 1):
    P, Q, R, S, W = map(int, input().split())
    aFee = P * W
    if W <= R:
        bFee = Q
    else:
        bFee = Q + (W - R) * S
    print(f"#{test_case} {min(aFee, bFee)}")
