import sys

m, n, k = map(int, sys.stdin.readline().split())
secret_btn = str(sys.stdin.readline().strip("\n"))
user_btn = str(sys.stdin.readline())

if user_btn.count(secret_btn):
    print("secret")
else:
    print("normal")
    
