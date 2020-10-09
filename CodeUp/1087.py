num = int(input())
sum = 0
for i in range(num+1):
    sum += i
    if sum >= num:
        print(sum)
        break
