n = int(input())
a = input().split()
numbers = []

for i in range(n):
    numbers.append(int(a[i]))

numbers.sort()

print(numbers[0])
