n = int(input())
li = []
result = []
for i in range(n):
    li.append([])
    a, b = map(int, input().split())
    li[i].append(a)
    li[i].append(b)

li.sort(key=lambda x: (x[1], x[0]))

result.append([])
result[0].append(li[0][0])
result[0].append(li[0][1])
for i in range(1, len(li), 1):
    if li[i][0] >= result[len(result)-1][1]:
        result.append([])
        result[len(result)-1].append(li[i][0])
        result[len(result)-1].append(li[i][1])
print(result)