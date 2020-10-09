w, h ,b = map(int, input().split())
result = w * h * b / 2**23
print("%.2f" %result + " MB")