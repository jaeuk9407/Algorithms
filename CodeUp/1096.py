n = int(input())
arr = []
for i in range(20):
    arr.append([])
    for j in range(20):
        arr[i].append(0)

for i in range(n):
    a, b = input().split()
    arr[int(a)][int(b)] = 1

for i in range(1, 20):
    for j in range(1, 20):
        print(arr[i][j], end=' ')
    print()


