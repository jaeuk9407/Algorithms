n = int(input())
a = input().split()
numbers = []

for i in range(n):
    numbers.append(int(a[i]))

#reversed를 사용하면 숫자의 순서를 반대로 뒤집는다.
for i in reversed(range(n)):
    print(numbers[i], end=' ')