li = list(map(int, input().split()))
for i in li:
    if i >= 0:
        print("plus")
    elif i<0:
        print("minus")

    if i % 2 == 0:
        print("even")
    elif i % 2 == 1:
        print("odd")

