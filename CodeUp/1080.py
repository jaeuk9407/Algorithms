num = int(input())
sum = 0
for i in range(num):
    sum += i
    if sum >= num:
        print(i)
        break
