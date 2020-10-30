import sys
a, p = map(int, sys.stdin.readline().split())
list = []
while a not in list:
    list.append(a)
    a = sum([int(i)**p for i in str(a)])

# 반복문은 중복값이 들어간 순간 멈추기 때문에 중복값이 발생한 자리의 인덱스는 반복제외숫자의 갯수이다.
print(list.index(a))
