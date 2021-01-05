import sys
t = int(sys.stdin.readline())

# 1, 2, 3의 합으로 나타내는 방법의 수를 담는 리스트
s = [1, 2, 4]

# n은 11보다 작다는 조건이 있어, 미리 계산해 저장
for i in range(3, 11):
    s.append(s[i-1]+s[i-2]+s[i-3])

for i in range(t):
    n = int(sys.stdin.readline())
    print(s[n-1])

