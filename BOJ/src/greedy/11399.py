n = int(input())
p = input().split()
wTime = []
for i in p:
    wTime.append(int(i))
wTime.sort()

sum = 0
for i in range(1, len(wTime)):
    wTime[i] = wTime[i-1] + wTime[i]
    sum += wTime[i]

sum += wTime[0]
print(sum)


