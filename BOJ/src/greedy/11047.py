n, k = map(int, input().split())
li = []
cnt = 0
for i in range(n):
    li.append(int(input()))

while k > 0:
    for i in range(n-1, -1, -1):
        if k//li[i] > 0:
            cnt += k//li[i]
            k %= li[i]

print(cnt)