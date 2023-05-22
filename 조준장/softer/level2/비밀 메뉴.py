m, n, k = map(int, sys.stdin.readline().split())
secret_num = str(sys.stdin.readline().replace(" ", "").rstrip())
nromal_num = str(sys.stdin.readline().replace(" ", ""))

if "*" in nromal_num.replace(secret_num, "*"):
    print("secret")
else:
    print("normal")
