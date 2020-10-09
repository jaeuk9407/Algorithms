x = int(input())
for i in range(1, x+1):
    if i % 3 == 0:
        print("X", end=" ")
    else:
        print(i, end=" ")
